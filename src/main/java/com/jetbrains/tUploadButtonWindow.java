package com.jetbrains;

/**
 * Created by kalistrat on 10.04.2017.
 */

import com.vaadin.ui.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tUploadButtonWindow {

    private MyReceiver receiver = new MyReceiver();

    public Upload upload = new Upload(null,receiver);

    public tUploadWindow UploadWindow;
    public String iUserLog;

    public tUploadButtonWindow(String eUserLog) {

        iUserLog = eUserLog;

        UploadWindow = new tUploadWindow(this);

        receiver.setSlow(true);
        upload.setImmediate(true);
        upload.setButtonCaption(" Изменить аватар");

        upload.addStyleName("myCustomUploadTiny");
        upload.addStyleName("upload-with-icon");

        upload.addListener(new Upload.StartedListener() {
            public void uploadStarted(Upload.StartedEvent event) {
                // This method gets called immediatedly after upload is started
                UI.getCurrent().addWindow(UploadWindow);
                UploadWindow.pi.setValue(0f);
                UploadWindow.status.setValue("Загружается файл \"" + event.getFilename()
                        + "\"");
            }
        });

        upload.addListener(new Upload.ProgressListener() {
            public void updateProgress(long readBytes, long contentLength) {
                // This method gets called several times during the update
                UploadWindow.pi.setValue(new Float(readBytes / (float) contentLength));
            }

        });

        upload.addListener(new Upload.SucceededListener() {
            public void uploadSucceeded(Upload.SucceededEvent event) {
                // This method gets called when the upload finished successfully
                UploadWindow.status.setValue("Файл \"" + event.getFilename()
                        + "\" успешно загружен");

            }
        });

        upload.addListener(new Upload.FailedListener() {
            public void uploadFailed(Upload.FailedEvent event) {
                // This method gets called when the upload failed
                UploadWindow.status.setValue("Загрузка прервана.");
            }
        });

        upload.addListener(new Upload.FinishedListener() {
            public void uploadFinished(Upload.FinishedEvent event) {

                Pattern PatternMime = Pattern.compile("/(.*)");
                Matcher matcherMime = PatternMime.matcher(event.getMIMEType());
                matcherMime.find();
                String FileMimeType = matcherMime.group(1);

                Pattern PatternType = Pattern.compile("(.*)/");
                Matcher matcherType = PatternType.matcher(event.getMIMEType());
                matcherType.find();
                String FileType = matcherType.group(1);

                Path SourceOldName = Paths.get(tAppCommonStatic.MyThemepath + "/ava/" + event.getFilename());

                if (FileType.equals("image")) {

                    Path SourceNewName = Paths.get(tAppCommonStatic.MyThemepath + "/ava/" + iUserLog + "." + FileMimeType);
                    Path Dst = Paths.get(tAppCommonStatic.MyThemepath + "/mava/" + iUserLog + "." + FileMimeType);

                    try {
                        Files.move(SourceOldName, SourceOldName.resolveSibling(iUserLog + "." + FileMimeType), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(SourceNewName, Dst, StandardCopyOption.REPLACE_EXISTING);
                        Files.move(Dst, Dst.resolveSibling("m_" + iUserLog + "." + FileMimeType), StandardCopyOption.REPLACE_EXISTING);

                        UploadWindow.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else{

                    try {
                        Files.delete(SourceOldName);
                        UploadWindow.status.setValue("Файл не загружен, т.к не является изображением. Выберите изображение.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }

    public static class MyReceiver implements Upload.Receiver {
        private String fileName;
        private String mtype;
        private boolean sleep;
        private int total = 0;

        OutputStream outputFile = null;
        @Override
        public OutputStream receiveUpload(String strFilename, String strMIMEType) {
            fileName = strFilename;
            mtype = strMIMEType;
            File file=null;
            try {
                file = new File(tAppCommonStatic.MyThemepath + "/ava/" + strFilename);
                if(!file.exists()) {
                    file.createNewFile();
                }
                outputFile =  new FileOutputStream(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return outputFile;
        }

        protected void finalize() {
            try {
                super.finalize();
                if(outputFile!=null) {
                    outputFile.close();
                }
            } catch (Throwable exception) {
                exception.printStackTrace();
            }
        }
        public String getFileName() {
            return fileName;
        }

        public String getMimeType() {
            return mtype;
        }

        public void setSlow(boolean value) {
            sleep = value;
        }

    }

}