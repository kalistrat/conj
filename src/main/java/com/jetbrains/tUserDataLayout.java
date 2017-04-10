package com.jetbrains;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.*;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by kalistrat on 29.03.2017.
 */
public class tUserDataLayout extends VerticalLayout {

    TextField LastNameField;
    TextField FirstNameField;
    TextField MiddleNameField;
    PopupDateField BirthDateField;
    TextField EmailField;
    TextField PhoneField;
    Image AvatarImage;
    VerticalLayout ImageLayout;
    Label LoginLabel;
    Label RatingLabel;
    Label RegDateLabel;
    Label BalanceLabel;
    String iUserLogin;

    Button ChangePersonButton;
    Button SavePersonButton;
    Button ChangeContactButton;
    Button SaveContactButton;

    Button InPayButton;
    Button OutPayButton;
    Button CrePayButton;
    Button ChangeAvaButton;

    public tUserDataLayout(String eUserLogin){

        this.iUserLogin = eUserLogin;

        tUploadButtonWindow iUpload = new tUploadButtonWindow();
        //ChangeAvaButton = iUpload.upload;


        //Поля формы персональных данных

        LastNameField = new TextField("Фамилия:");
        FirstNameField = new TextField("Имя:");
        MiddleNameField = new TextField("Отчество:");

        //LastNameField.addStyleName(ValoTheme.TEXTFIELD_TINY);
        //FirstNameField.addStyleName(ValoTheme.TEXTFIELD_TINY);
        //MiddleNameField.addStyleName(ValoTheme.TEXTFIELD_TINY);

        LastNameField.setEnabled(false);
        FirstNameField.setEnabled(false);
        MiddleNameField.setEnabled(false);

        BirthDateField = new PopupDateField("Дата рождения:"){
            @Override
            protected Date handleUnparsableDateString(String dateString)
                    throws Converter.ConversionException {
                throw new Converter.ConversionException("Формат даты неверен. Используйте dd.mm.yy h24:mi:ss");
            }
        };
        BirthDateField.setResolution(BirthDateField.RESOLUTION_DAY);
        BirthDateField.setImmediate(true);
        BirthDateField.setEnabled(false);


        //BirthDateField.addStyleName(ValoTheme.TEXTFIELD_SMALL);

        // Поля формы контактов

        EmailField = new TextField("Электронная почта:");
        EmailField.setIcon(VaadinIcons.ENVELOPE);
        PhoneField = new TextField("Номер телефона:");
        PhoneField.setIcon(VaadinIcons.PHONE);
        EmailField.setEnabled(false);
        PhoneField.setEnabled(false);

        //EmailField.addStyleName(ValoTheme.TEXTFIELD_SMALL);
        //PhoneField.addStyleName(ValoTheme.TEXTFIELD_SMALL);

        // Заголовки форм
        Label FioFormHeader = new Label();
        FioFormHeader.setContentMode(ContentMode.HTML);
        FioFormHeader.setValue(VaadinIcons.USER_CARD.getHtml() + "  " + "Персональные данные");
        FioFormHeader.addStyleName(ValoTheme.LABEL_COLORED);
        FioFormHeader.addStyleName(ValoTheme.LABEL_SMALL);

        Label ContactFormHeader = new Label();
        ContactFormHeader.setContentMode(ContentMode.HTML);
        ContactFormHeader.setValue(VaadinIcons.LOCATION_ARROW_CIRCLE.getHtml() + "  " + "Контактные данные");
        ContactFormHeader.addStyleName(ValoTheme.LABEL_COLORED);
        ContactFormHeader.addStyleName(ValoTheme.LABEL_SMALL);

        Label BalanceFormHeader = new Label();
        BalanceFormHeader.setContentMode(ContentMode.HTML);
        BalanceFormHeader.setValue(VaadinIcons.COIN_PILES.getHtml() + "  " + "Изменение баланса");
        BalanceFormHeader.addStyleName(ValoTheme.LABEL_COLORED);
        BalanceFormHeader.addStyleName(ValoTheme.LABEL_SMALL);


        FormLayout FioVertLineForm = new FormLayout(
                LastNameField
                ,FirstNameField
                ,MiddleNameField
                ,BirthDateField
                //,new Label()
        );
        FioVertLineForm.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);

        FormLayout ContactVertLineForm = new FormLayout(
                EmailField
                ,PhoneField
                //,new Label()
        );

        ContactVertLineForm.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        //Кнопки

        ChangePersonButton = new Button();
        ChangePersonButton.setIcon(FontAwesome.PENCIL);

        SavePersonButton = new Button();
        SavePersonButton.setIcon(FontAwesome.SAVE);
        SavePersonButton.setEnabled(false);

        ChangeContactButton = new Button();
        ChangeContactButton.setIcon(FontAwesome.PENCIL);

        SaveContactButton = new Button();
        SaveContactButton.setIcon(FontAwesome.SAVE);
        SaveContactButton.setEnabled(false);

        InPayButton = new Button("Попольнить баланс");
        InPayButton.setIcon(VaadinIcons.MONEY_DEPOSIT);
        OutPayButton = new Button("Вывести выигрыш");
        OutPayButton.setIcon(VaadinIcons.MONEY_WITHDRAW);
        CrePayButton = new Button("Поделиться");
        CrePayButton.setIcon(VaadinIcons.SHARE_SQUARE);

        ChangePersonButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        SavePersonButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        ChangePersonButton.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        SavePersonButton.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);

        ChangeContactButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        SaveContactButton.addStyleName(ValoTheme.BUTTON_ICON_ONLY);
        ChangeContactButton.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        SaveContactButton.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);

        HorizontalLayout ChangePersonalDataLayout = new HorizontalLayout(
                ChangePersonButton
                ,SavePersonButton
        );

        HorizontalLayout ChangeContactDataLayout = new HorizontalLayout(
                ChangeContactButton
                ,SaveContactButton
        );


        InPayButton.addStyleName(ValoTheme.BUTTON_SMALL);
        OutPayButton.addStyleName(ValoTheme.BUTTON_SMALL);
        CrePayButton.addStyleName(ValoTheme.BUTTON_SMALL);

        InPayButton.addStyleName(ValoTheme.BUTTON_LINK);
        OutPayButton.addStyleName(ValoTheme.BUTTON_LINK);
        CrePayButton.addStyleName(ValoTheme.BUTTON_LINK);

        ChangeAvaButton = new Button("Изменить аватар");
        ChangeAvaButton.setIcon(VaadinIcons.PICTURE);
        ChangeAvaButton.addStyleName(ValoTheme.BUTTON_LINK);
        ChangeAvaButton.addStyleName(ValoTheme.BUTTON_TINY);

        HorizontalLayout ButtonsFormLayout = new HorizontalLayout(
                InPayButton
                ,OutPayButton
                ,CrePayButton
        );
        ButtonsFormLayout.setSpacing(true);

        ChangeContactButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                EmailField.setEnabled(true);
                PhoneField.setEnabled(true);

                SaveContactButton.setEnabled(true);
                ChangeContactButton.setEnabled(false);
            }
        });

        ChangePersonButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                FirstNameField.setEnabled(true);
                LastNameField.setEnabled(true);
                MiddleNameField.setEnabled(true);
                BirthDateField.setEnabled(true);

                SavePersonButton.setEnabled(true);
                ChangePersonButton.setEnabled(false);
            }
        });

        SaveContactButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
             ChangeContactData(
                     EmailField.getValue()
                     ,PhoneField.getValue()
             );
                EmailField.setEnabled(false);
                PhoneField.setEnabled(false);

                SaveContactButton.setEnabled(false);
                ChangeContactButton.setEnabled(true);
            }
        });

        SavePersonButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ChangePersonData(
                        FirstNameField.getValue()
                        ,LastNameField.getValue()
                        ,MiddleNameField.getValue()
                        ,BirthDateField.getValue()
                );
                FirstNameField.setEnabled(false);
                LastNameField.setEnabled(false);
                MiddleNameField.setEnabled(false);
                BirthDateField.setEnabled(false);

                SavePersonButton.setEnabled(false);
                ChangePersonButton.setEnabled(true);
            }
        });

        HorizontalLayout FioFormHeaderLayout = new HorizontalLayout(
                FioFormHeader
                ,ChangePersonalDataLayout
        );
        FioFormHeaderLayout.setSpacing(true);
        FioFormHeaderLayout.setWidth("100%");
        FioFormHeaderLayout.setComponentAlignment(ChangePersonalDataLayout,Alignment.TOP_RIGHT);

        HorizontalLayout ContactFormHeaderLayout = new HorizontalLayout(
                ContactFormHeader
                ,ChangeContactDataLayout
        );
        ContactFormHeaderLayout.setSpacing(true);
        ContactFormHeaderLayout.setWidth("100%");
        ContactFormHeaderLayout.setComponentAlignment(ChangeContactDataLayout,Alignment.TOP_RIGHT);


        VerticalLayout RightContentLayout = new VerticalLayout(
                FioFormHeaderLayout
                ,FioVertLineForm
                ,ContactFormHeaderLayout
                ,ContactVertLineForm
                ,BalanceFormHeader
                ,new Label()
                ,ButtonsFormLayout
        );

        RightContentLayout.setMargin(true);

        AvatarImage = new Image(null, new ClassResource("/pics/ava7.png"));
        AvatarImage.setHeight(120,Unit.PIXELS);
        AvatarImage.setWidth(120,Unit.PIXELS);
        ImageLayout = new VerticalLayout(AvatarImage);
        ImageLayout.addStyleName(ValoTheme.LAYOUT_WELL);
        ImageLayout.setWidth("120px");
        ImageLayout.setHeight("120px");
        ImageLayout.setComponentAlignment(AvatarImage,Alignment.MIDDLE_CENTER);

        LoginLabel = new Label();
        LoginLabel.addStyleName(ValoTheme.LABEL_COLORED);
        LoginLabel.setContentMode(ContentMode.HTML);
        LoginLabel.addStyleName(ValoTheme.LABEL_SMALL);

        VerticalLayout LoginLabelLayout = new VerticalLayout(
                LoginLabel
        );
        LoginLabelLayout.setComponentAlignment(LoginLabel,Alignment.MIDDLE_CENTER);
        LoginLabelLayout.setSizeUndefined();

        RatingLabel = new Label();
        RatingLabel.addStyleName(ValoTheme.LABEL_TINY);
        RatingLabel.setContentMode(ContentMode.HTML);
        RatingLabel.setValue(VaadinIcons.BAR_CHART.getHtml() + " Рейтинг : ");

        RegDateLabel = new Label();
        RegDateLabel.addStyleName(ValoTheme.LABEL_TINY);
        RegDateLabel.setContentMode(ContentMode.HTML);
        RegDateLabel.setValue(VaadinIcons.TIME_FORWARD.getHtml() + " На сайте с : ");

        BalanceLabel = new Label();
        BalanceLabel.addStyleName(ValoTheme.LABEL_TINY);
        BalanceLabel.setContentMode(ContentMode.HTML);
        BalanceLabel.setValue(VaadinIcons.CASH.getHtml() + " Баланс : ");

        VerticalLayout RatingDateFromLayout = new VerticalLayout(
               RatingLabel
                ,RegDateLabel
                ,BalanceLabel
        );

        VerticalLayout AvaLayout = new VerticalLayout(
                LoginLabelLayout
                ,ImageLayout
                ,ChangeAvaButton
                ,RatingDateFromLayout
                //,ChangeAvaButton
        );
        AvaLayout.setSpacing(true);

        AvaLayout.setComponentAlignment(LoginLabelLayout,Alignment.TOP_CENTER);
        AvaLayout.setComponentAlignment(ImageLayout,Alignment.MIDDLE_CENTER);
        AvaLayout.setComponentAlignment(RatingDateFromLayout,Alignment.BOTTOM_CENTER);
        AvaLayout.setComponentAlignment(ChangeAvaButton,Alignment.BOTTOM_CENTER);

        AvaLayout.setSizeUndefined();

        VerticalLayout LeftContentLayout = new VerticalLayout(
                AvaLayout
        );
        LeftContentLayout.setComponentAlignment(AvaLayout,Alignment.TOP_CENTER);
        LeftContentLayout.setMargin(new MarginInfo(true,false,false,false));
        //LeftContentLayout.setSpacing(true);

        HorizontalSplitPanel UserDataSection = new HorizontalSplitPanel();
        UserDataSection.setHeight("750px");
        UserDataSection.setWidth("800px");
        UserDataSection.setFirstComponent(LeftContentLayout);
        UserDataSection.setSecondComponent(RightContentLayout);
        UserDataSection.setSplitPosition(25f,UNITS_PERCENTAGE);
        UserDataSection.setMinSplitPosition(25f,UNITS_PERCENTAGE);
        UserDataSection.setMaxSplitPosition(25f,UNITS_PERCENTAGE);

        VerticalLayout ContentLayout = new VerticalLayout(UserDataSection);
        ContentLayout.setHeight("750px");
        ContentLayout.setWidth("800px");
        ContentLayout.addStyleName(ValoTheme.LAYOUT_CARD);

        SetUserDataLayoutData();

        this.addComponent(new Label());
        this.addComponent(ContentLayout);
        this.addComponent(new Label());

        this.setComponentAlignment(ContentLayout,Alignment.MIDDLE_CENTER);

    }

    public void SetUserDataLayoutData(){

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");


        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String LayoutDataSql = "select p.player_log\n" +
                    ",p.player_first_name\n" +
                    ",p.player_last_name\n" +
                    ",p.player_middle_name\n" +
                    ",p.player_birth_date\n" +
                    ",p.player_email\n" +
                    ",p.player_phone\n" +
                    ",p.player_ava\n" +
                    ",p.balance\n" +
                    ",p.registration_date\n" +
                    ",p.rating\n" +
                    "from player p\n" +
                    "where p.player_log = ?";

            PreparedStatement LayoutDataStmt = Con.prepareStatement(LayoutDataSql);
            LayoutDataStmt.setString(1,this.iUserLogin);

            ResultSet LayoutDataRs = LayoutDataStmt.executeQuery();

            while (LayoutDataRs.next()) {

                LoginLabel.setValue(VaadinIcons.USER.getHtml() + "  "
                        + LayoutDataRs.getString(1));
                FirstNameField.setValue(LayoutDataRs.getString(2));
                LastNameField.setValue(LayoutDataRs.getString(3));
                MiddleNameField.setValue(LayoutDataRs.getString(4));
                BirthDateField.setValue(LayoutDataRs.getDate(5));
                EmailField.setValue(LayoutDataRs.getString(6));
                PhoneField.setValue(LayoutDataRs.getString(7));


                if (LayoutDataRs.getString(8)!=null){

                    Image NewAvatarImage = new Image(null, new ClassResource("/pics/"+LayoutDataRs.getString(8)));
                    NewAvatarImage.setHeight(100,Unit.PIXELS);
                    NewAvatarImage.setWidth(100,Unit.PIXELS);
                    ImageLayout.replaceComponent(AvatarImage,NewAvatarImage);
                    AvatarImage = NewAvatarImage;
                }

                BalanceLabel.setValue(BalanceLabel.getValue() + LayoutDataRs.getDouble(9));
                RegDateLabel.setValue(RegDateLabel.getValue() + df.format(new Date(LayoutDataRs.getTimestamp(10).getTime())));
                RatingLabel.setValue(RatingLabel.getValue() + LayoutDataRs.getDouble(11));

            }


            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }

    }

    public void ChangeContactData(String iNewEmailValue,String iNewPhoneValue){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement ChangeContactDataStmt = Con.prepareCall("{call p_user_contact_data_update(?, ? ,?)}");
            ChangeContactDataStmt.setString(1, this.iUserLogin);
            ChangeContactDataStmt.setString(2, iNewEmailValue);
            ChangeContactDataStmt.setString(3, iNewPhoneValue);
            ChangeContactDataStmt.execute();

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }

    }

    public void ChangePersonData(
        String iNewFirstName
        ,String iNewLastName
        ,String iNewMiddleName
        ,Date iBirthDate
    ){

        java.sql.Date sqlBirthDate = new java.sql.Date(iBirthDate.getTime());

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement ChangePersonDataStmt = Con.prepareCall("{call p_user_person_data_update(?, ? ,? ,? ,?)}");
            ChangePersonDataStmt.setString(1, this.iUserLogin);
            ChangePersonDataStmt.setString(2, iNewFirstName);
            ChangePersonDataStmt.setString(3, iNewLastName);
            ChangePersonDataStmt.setString(4, iNewMiddleName);
            ChangePersonDataStmt.setDate(5, sqlBirthDate);

            ChangePersonDataStmt.execute();

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
