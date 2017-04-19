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
import java.sql.*;
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

        upload.addStartedListener(new Upload.StartedListener() {
            @Override
            public void uploadStarted(Upload.StartedEvent startedEvent) {
                UI.getCurrent().addWindow(UploadWindow);
                UploadWindow.pi.setValue(0f);
                UploadWindow.status.setValue("Загружается файл \"" + startedEvent.getFilename()
                        + "\"");
            }
        });

        upload.addProgressListener(new Upload.ProgressListener() {
            @Override
            public void updateProgress(long l, long l1) {
                UploadWindow.pi.setValue(new Float(l / (float) l1));

            }
        });

        upload.addSucceededListener(new Upload.SucceededListener() {
            @Override
            public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
                UploadWindow.status.setValue("Файл \"" + succeededEvent.getFilename()
                        + "\" успешно загружен");
            }
        });

        upload.addFailedListener(new Upload.FailedListener() {
            @Override
            public void uploadFailed(Upload.FailedEvent failedEvent) {
                UploadWindow.status.setValue("Загрузка прервана.");
            }
        });

        upload.addFinishedListener(new Upload.FinishedListener() {
            @Override
            public void uploadFinished(Upload.FinishedEvent finishedEvent) {
                Pattern PatternMime = Pattern.compile("/(.*)");
                Matcher matcherMime = PatternMime.matcher(finishedEvent.getMIMEType());
                matcherMime.find();
                String FileMimeType = matcherMime.group(1);

                Pattern PatternType = Pattern.compile("(.*)/");
                Matcher matcherType = PatternType.matcher(finishedEvent.getMIMEType());
                matcherType.find();
                String FileType = matcherType.group(1);

                Path SourceOldName = Paths.get(tAppCommonStatic.MyThemepath + "/ava/" + finishedEvent.getFilename());

                if (FileType.equals("image")) {

                    String sNewFileName = GetAvaFileName();

                    Path SourceNewName = Paths.get(tAppCommonStatic.MyThemepath + "/ava/" + sNewFileName);
                    Path Dst = Paths.get(tAppCommonStatic.MyThemepath + "/mava/" + sNewFileName);
                    int MiniImgWidth = 30;
                    int MiniImgHeight = 30;


                    try {
                        Files.move(SourceOldName, SourceOldName.resolveSibling(sNewFileName), StandardCopyOption.REPLACE_EXISTING);
                        Files.copy(SourceNewName, Dst, StandardCopyOption.REPLACE_EXISTING);

                        BufferedImage originalImage = ImageIO.read(new File(tAppCommonStatic.MyThemepath + "/mava/" + sNewFileName));
                        int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                        BufferedImage resizeImageJpg = resizeImage(originalImage, type, MiniImgWidth, MiniImgHeight);
                        ImageIO.write(resizeImageJpg, FileMimeType, new File(tAppCommonStatic.MyThemepath + "/mava/" + "m_" + sNewFileName));
                        Files.delete(Dst);

                        Image iNewAvatarImage = new Image(null, new ThemeResource("ava/" + sNewFileName));
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

    public String GetAvaFileName(){

        String NewAvaFileName = "";

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement ChangeAvaStmt = Con.prepareCall("{? = call f_user_ava_change(?)}");
            ChangeAvaStmt.registerOutParameter(1, Types.VARCHAR);
            ChangeAvaStmt.setString(2, this.iUserLog);
            ChangeAvaStmt.execute();
            NewAvaFileName = ChangeAvaStmt.getString(1);

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }

        return NewAvaFileName;

    }


}