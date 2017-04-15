package com.jetbrains;

/**
 * Created by kalistrat on 10.04.2017.
 */

import com.vaadin.data.fieldgroup.Caption;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

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

    public tUploadButtonWindow() {

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
                System.out.println("Создаю окно ");
                UploadWindow.pi.setValue(0f);
                //UploadWindow.pi.setPollingInterval(500);
                UploadWindow.status.setValue("Загружается файл \"" + event.getFilename()
                        + "\"");
                System.out.println("Начало загрузки: " + event.getFilename());
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
                //System.out.println("Succeeded " + event.getFilename());
            }
        });

        upload.addListener(new Upload.FailedListener() {
            public void uploadFailed(Upload.FailedEvent event) {
                // This method gets called when the upload failed
                UploadWindow.status.setValue("Загрузка файла прервана");
            }
        });

        upload.addListener(new Upload.FinishedListener() {
            public void uploadFinished(Upload.FinishedEvent event) {

                String mydata = event.getMIMEType();
                System.out.println(mydata);
                Pattern pattern = Pattern.compile("/(.*)");
                Matcher matcher = pattern.matcher(mydata);
                if (matcher.find())
                {
                    System.out.println(matcher.group(1));
                }

                Path source = Paths.get(tAppCommonStatic.MyThemepath + "/ava/" + event.getFilename());
                try {
                    Files.move(source, source.resolveSibling("newname.png"), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("MyThemepath " + tAppCommonStatic.MyThemepath + "/ava/" + event.getFilename());
                //UploadWindow.close();

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
                //file.renameTo(new File(tAppCommonStatic.MyThemepath + "/ava/" + "kalistrat." + strMIMEType));

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