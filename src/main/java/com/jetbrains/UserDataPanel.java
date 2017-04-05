package com.jetbrains;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;
import java.sql.*;

/**
 * Created by SemenovNA on 03.08.2016.
 */
public class UserDataPanel extends Panel {

    //  Database credentials
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/conjuncture";
    private static final String USER = "gumbler";
    private static final String PASS = "tutunia";

    public UserDataPanel(String CurrentUser){


        String UserLogVal  = null;
        String UserPhoneVal  = null;
        String UserFirstNameVal  = null;
        String UserLastNameVal  = null;
        String UserMidNameVal  = null;
        Date UserBirthVal = null;
        String UserAvaPathVal  = null;
        String UserEmailVal  = null;
        Double UserBalanceVal  = null;

        Label UserLogLabel = new Label();

        TextField UserBalanceField = new TextField("Баланс");
        UserBalanceField.setWidth("200px");
        TextField UserPhoneField = new TextField("Телефон");
        UserPhoneField.setWidth("200px");
        TextField UserFirstNameField = new TextField("Имя");
        UserFirstNameField.setWidth("200px");
        TextField UserLastNameField = new TextField("Фамилия");
        UserLastNameField.setWidth("200px");
        TextField UserMidNameField = new TextField("Отчество");
        UserMidNameField.setWidth("200px");
        PopupDateField UserBirthField = new PopupDateField("Дата рождения");
        UserBirthField.setWidth("200px");
        TextField UserEmailField = new TextField("E-mail");
        UserEmailField.setWidth("200px");

        Button EditUserDataButton = new Button("Изменить личные данные");
        Button SaveUserDataButton = new Button("Сохранить личные данные");



        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String UserDataSQL = "select p.player_log\n" +
                    ",p.player_phone\n" +
                    ",p.player_first_name\n" +
                    ",p.player_last_name\n" +
                    ",p.player_middle_name\n" +
                    ",p.player_birth_date\n" +
                    ",p.player_ava\n" +
                    ",p.player_email\n" +
                    ",p.balance\n" +
                    "from player p\n" +
                    "where p.player_log = ?";

            PreparedStatement UserDataStmt = conn.prepareStatement(UserDataSQL);
            UserDataStmt.setString(1, CurrentUser);
            ResultSet UserDataRes = UserDataStmt.executeQuery();

            while (UserDataRes.next()){

                UserLogVal  = UserDataRes.getString(1);
                UserPhoneVal  = UserDataRes.getString(2);
                UserFirstNameVal  = UserDataRes.getString(3);
                UserLastNameVal  = UserDataRes.getString(4);
                UserMidNameVal  = UserDataRes.getString(5);
                UserBirthVal = UserDataRes.getDate(6);
                UserAvaPathVal  = UserDataRes.getString(7);
                UserEmailVal  = UserDataRes.getString(8);
                UserBalanceVal  = UserDataRes.getDouble(9);
            }

            conn.close();
        } catch(SQLException SQLe){
            //Handle errors for JDBC
            SQLe.printStackTrace();
        } catch(Exception e1){
            //Handle errors for Class.forName
            e1.printStackTrace();
        }

        UserLogLabel.setValue(UserLogVal);
        UserBalanceField.setValue(String.valueOf(UserBalanceVal));

        UserPhoneField.setValue(UserPhoneVal);
        UserFirstNameField.setValue(UserFirstNameVal);
        UserLastNameField.setValue(UserLastNameVal);
        UserMidNameField.setValue(UserMidNameVal);
        UserBirthField.setValue(UserBirthVal);

        if (UserAvaPathVal == null) {
            UserAvaPathVal = "human.jpg";
        }

        String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        FileResource resource = new FileResource(new File(basepath + "/VAADIN/themes/mytheme/pics/" + "human.jpg"));
        Embedded AvatarImage = new Embedded(null,resource);
        UserEmailField.setValue(UserEmailVal);

        VerticalLayout UserDataBox = new VerticalLayout();
//        VerticalLayout EmptyTop = new VerticalLayout();
//        VerticalLayout EmptyBottom = new VerticalLayout();

        UserDataBox.addComponent(UserLogLabel);
        UserDataBox.addComponent(AvatarImage);
        UserDataBox.addComponent(UserBalanceField);
        UserDataBox.addComponent(UserLastNameField);
        UserDataBox.addComponent(UserFirstNameField);
        UserDataBox.addComponent(UserMidNameField);
        UserDataBox.addComponent(UserBirthField);
        UserDataBox.addComponent(UserPhoneField);
        UserDataBox.addComponent(UserEmailField);
        UserDataBox.addComponent(EditUserDataButton);
        UserDataBox.addComponent(SaveUserDataButton);

        UserDataBox.setSpacing(true);
        UserDataBox.setSizeFull();
        UserDataBox.setComponentAlignment(AvatarImage,Alignment.MIDDLE_CENTER);

        VerticalLayout PanelContent = new VerticalLayout();

        //PanelContent.setSpacing(true);
        PanelContent.addComponent(UserDataBox);

        PanelContent.setSizeFull();

        this.setContent(PanelContent);
        this.setCaption("Личные данные");




    }
}
