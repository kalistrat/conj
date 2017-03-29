package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;

/**
 * Created by SemenovNA on 02.08.2016.
 */
public class GLoginView extends CustomComponent implements View {

    public static final String NAME = "Login";

    //Кнопки
    Button LogOnButton = new Button("Войти");
    Button RemindPassButton = new Button("Напомнить пароль");
    Button RegButton = new Button("Регистрация");

    //Метка
    Label LogInLabel = new Label("Авторизация");

    //Поля
    TextField LogInField = new TextField("Имя пользователя");
    PasswordField PassField = new PasswordField("Пароль");



    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/conjuncture";

    //  Database credentials
    private static final String USER = "gumbler";
    private static final String PASS = "tutunia";


    public GLoginView(){
        setSizeFull();
        VerticalLayout LoginViewLayOut = new VerticalLayout();


        VerticalLayout LoginBox = new VerticalLayout();
        LoginBox.setSpacing(true);

        LogInField.setWidth("300px");
        LogInField.setIcon(VaadinIcons.USER);
        PassField.setWidth("300px");
        PassField.setIcon(VaadinIcons.KEY);


        LogInLabel.setSizeUndefined();
        LoginBox.addComponent(LogInLabel);

        LoginBox.addComponent(LogInField);
        LoginBox.addComponent(PassField);

        LoginBox.setComponentAlignment(LogInLabel,Alignment.MIDDLE_CENTER);
        LoginBox.setComponentAlignment(LogInField,Alignment.MIDDLE_LEFT);
        LoginBox.setComponentAlignment(PassField,Alignment.MIDDLE_LEFT);

        HorizontalLayout ButtonsBox = new HorizontalLayout();
        ButtonsBox.setSpacing(true);
        ButtonsBox.setSizeUndefined();

        LogOnButton.setSizeUndefined();
        RemindPassButton.setSizeUndefined();
        LogOnButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                String username = LogInField.getValue();
                String password = PassField.getValue();
                Integer IsPlayerExists = 0;

                try {
                    Class.forName(JDBC_DRIVER);
                    Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

                    CallableStatement CheckUserStmt = conn.prepareCall("{? = call f_is_user_exists(?, ?)}");
                    CheckUserStmt.registerOutParameter (1, Types.INTEGER);
                    CheckUserStmt.setString(2, username);
                    CheckUserStmt.setString(3, password);
                    CheckUserStmt.execute();
                    IsPlayerExists = CheckUserStmt.getInt(1);

                    conn.close();
                } catch(SQLException SQLe){
                //Handle errors for JDBC
                SQLe.printStackTrace();
                }catch(Exception e1){
                    //Handle errors for Class.forName
                    e1.printStackTrace();
                }

                if (IsPlayerExists.equals(1)) {

                    // Store the current user in the service session
                    getSession().setAttribute("user", username);

                    // Navigate to main view
                    getUI().getNavigator().navigateTo(GMainView.NAME);//

                } else {

                    PassField.setValue("");
                    LogInField.setValue("");
                    PassField.focus();
                    Notification PassWrongNotication = new Notification("Несуществующее сочетание логина и пароля","");
                    PassWrongNotication.show(Page.getCurrent());

                }
            }
        });

        ButtonsBox.addComponent(LogOnButton);
        ButtonsBox.addComponent(RemindPassButton);
        ButtonsBox.setComponentAlignment(LogOnButton,Alignment.BOTTOM_LEFT);
        ButtonsBox.setComponentAlignment(RemindPassButton,Alignment.BOTTOM_RIGHT);

        LoginBox.addComponent(ButtonsBox);
        LoginBox.setComponentAlignment(ButtonsBox,Alignment.MIDDLE_LEFT);
        LoginBox.setSizeUndefined();

        RegButton.addStyleName(ValoTheme.BUTTON_LINK);

        LoginViewLayOut.addComponent(RegButton);
        LoginViewLayOut.setComponentAlignment(RegButton,Alignment.TOP_RIGHT);

        LoginViewLayOut.addComponent(LoginBox);
        LoginViewLayOut.setComponentAlignment(LoginBox,Alignment.MIDDLE_CENTER);

        LoginViewLayOut.setSizeFull();

        LoginViewLayOut.setExpandRatio(LoginBox,2);



        setCompositionRoot(LoginViewLayOut);

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // focus the username field when user arrives to the login view
        LogInField.focus();
    }

}
