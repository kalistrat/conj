package com.jetbrains;

/**
 * Created by kalistrat on 10.04.2017.
 */

import com.vaadin.server.FileResource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;
import com.vaadin.ui.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tUploadButtonWindow {

    private MyReceiver receiver = new MyReceiver();

    public Upload upload = new Upload(null,receiver);

    public tUploadWindow UploadWindow;
    public String iUserLog;
    public tUserDataLayout iUserDataLayout;

    public tUploadButtonWindow(String eUserLog,tUserDataLayout eUserDataLayout) {

        iUserLog = eUserLog;
        iUserDataLayout = eUserDataLayout;

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

                    Path SourceNewName = Paths.get(tAppCommonStatic.MyThemepath + "/ava/" + iUserLog + "." + "png");
                    Path Dst = Paths.get(tAppCommonStatic.MyThemepath + "/mava/" + iUserLog + "." + "png");
                    int MiniImgWidth = 30;
                    int MiniImgHeight = 30;

                    try {
                        Files.move(SourceOldName, SourceOldName.resolveSibling(iUserLog + "." + "png"), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(SourceNewName, Dst, StandardCopyOption.REPLACE_EXISTING);

                        BufferedImage originalImage = ImageIO.read(new File(tAppCommonStatic.MyThemepath + "/mava/" + iUserLog + "." + "png"));
                        int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                        BufferedImage resizeImageJpg = resizeImage(originalImage, type, MiniImgWidth, MiniImgHeight);
                        ImageIO.write(resizeImageJpg, FileMimeType, new File(tAppCommonStatic.MyThemepath + "/mava/" + "m_" + iUserLog + "." + "png"));
                        Files.delete(Dst);

                        ChangePlayerAva(iUserLog + "." + "png");

                        Image iNewAvatarImage = new Image(null, new FileResource(new File(tAppCommonStatic.MyThemepath + "/ava/" + iUserLog + "." + "png")));
                        iNewAvatarImage.setHeight(100, Sizeable.Unit.PIXELS);
                        iNewAvatarImage.setWidth(100, Sizeable.Unit.PIXELS);
                        iUserDataLayout.ImageLayout.replaceComponent(iUserDataLayout.AvatarImage,iNewAvatarImage);
                        iUserDataLayout.AvatarImage = iNewAvatarImage;



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

        public BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT){
            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();

            return resizedImage;
        }

        public BufferedImage resizeImageWithHint(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT){

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            return resizedImage;
        }

    public void ChangePlayerAva(String iUserNewAvaFileName){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement ChangeAvaStmt = Con.prepareCall("{call p_user_ava_update(?, ?)}");
            ChangeAvaStmt.setString(1, this.iUserLog);
            ChangeAvaStmt.setString(2, iUserNewAvaFileName);
            ChangeAvaStmt.execute();

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }

    }


}