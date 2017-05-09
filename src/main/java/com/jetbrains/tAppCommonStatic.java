package com.jetbrains;


import com.vaadin.server.VaadinService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalistrat on 05.04.2017.
 */
public class tAppCommonStatic {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/conjuncture";
    public static final String USER = "gumbler";
    public static final String PASS = "tutunia";

    //String path = VaadinService.getCurrent().getDeploymentConfiguration().getResourcesPath() + "/VAADIN/themes/" + UI.getCurrent().getTheme() + "/" + specificResourcePath;

    static String MyThemepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath().replace("\\","/") + "/VAADIN/themes/mytheme";


    public static Integer StrToIntValue(String Sval) {

        try {
            //System.out.println(Sval);
            return Integer.parseInt(Sval);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static List<String> GetListFromString(String DevidedString){
        List<String> StrPieces = new ArrayList<String>();
        int k = 0;
        String iDevidedString = DevidedString;

        while (!iDevidedString.equals("")) {
            int Pos = iDevidedString.indexOf("/");
            StrPieces.add(iDevidedString.substring(0, Pos));
            iDevidedString = iDevidedString.substring(Pos + 1);
            k = k + 1;
            if (k > 100000) {
                iDevidedString = "";
            }
        }

        return StrPieces;
    }

    public static void closeGamePlayer(int qGameId, String qUserLog){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement CloseGamePlayerStmt = Con.prepareCall("{call p_close_game_player(?, ?, ?)}");
            CloseGamePlayerStmt.setInt(1, qGameId);
            CloseGamePlayerStmt.setString(2, qUserLog);
            CloseGamePlayerStmt.setString(3, "R");
            CloseGamePlayerStmt.execute();

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }
    }

    public static int getLastUserGame(String eUserLog){
        int gameid = 0;

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement CurrentGameStmt = Con.prepareCall("{? = call f_current_game_by_user(?)}");
            CurrentGameStmt.registerOutParameter (1, Types.INTEGER);
            CurrentGameStmt.setString(2, eUserLog);

            CurrentGameStmt.execute();
            gameid = CurrentGameStmt.getInt(1);
            //System.out.println(gameid);
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return gameid;
    }


//    public class ImageTest {
//
//        private static final int IMG_WIDTH = 100;
//        private static final int IMG_HEIGHT = 100;
//
//        public static void main(String [] args){
//
//            try{
//
//                BufferedImage originalImage = ImageIO.read(new File("c:\\image\\mkyong.jpg"));
//                int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
//
//                BufferedImage resizeImageJpg = resizeImage(originalImage, type);
//                ImageIO.write(resizeImageJpg, "jpg", new File("c:\\image\\mkyong_jpg.jpg"));
//
//                BufferedImage resizeImagePng = resizeImage(originalImage, type);
//                ImageIO.write(resizeImagePng, "png", new File("c:\\image\\mkyong_png.jpg"));
//
//                BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
//                ImageIO.write(resizeImageHintJpg, "jpg", new File("c:\\image\\mkyong_hint_jpg.jpg"));
//
//                BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
//                ImageIO.write(resizeImageHintPng, "png", new File("c:\\image\\mkyong_hint_png.jpg"));
//
//            }catch(IOException e){
//                System.out.println(e.getMessage());
//            }
//
//        }
//
//        private static BufferedImage resizeImage(BufferedImage originalImage, int type){
//            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
//            Graphics2D g = resizedImage.createGraphics();
//            g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
//            g.dispose();
//
//            return resizedImage;
//        }
//
//        private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type){
//
//            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
//            Graphics2D g = resizedImage.createGraphics();
//            g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
//            g.dispose();
//            g.setComposite(AlphaComposite.Src);
//
//            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//            g.setRenderingHint(RenderingHints.KEY_RENDERING,
//                    RenderingHints.VALUE_RENDER_QUALITY);
//            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                    RenderingHints.VALUE_ANTIALIAS_ON);
//
//            return resizedImage;
//        }
//    }

}
