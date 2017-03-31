package com.jetbrains;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.io.File;
import java.util.Date;

/**
 * Created by kalistrat on 29.03.2017.
 */
public class tUserDataLayout extends VerticalLayout {

    TextField SecondNameField;
    TextField FirstNameField;
    TextField MiddleNameField;
    PopupDateField BirthDateField;
    TextField EmailField;
    TextField PhoneField;
    Image AvatarImage;
    Label LoginLabel;
    Label RatingLabel;
    Label RegDateLabel;
    //TextField UserRatingField;
    //TextField UserDateRegField;
    TextField UserBalanceField;
    TextField UserCountGameField;

    public tUserDataLayout(){

        SecondNameField = new TextField();
        SecondNameField.setCaption("Фамилия:");

        FirstNameField = new TextField();
        FirstNameField.setCaption("Имя:");

        MiddleNameField = new TextField();
        MiddleNameField.setCaption("Отчество:");

        BirthDateField = new PopupDateField("Дата рождения:"){
            @Override
            protected Date handleUnparsableDateString(String dateString)
                    throws Converter.ConversionException {
                throw new Converter.ConversionException("Формат даты неверен. Используйте dd.mm.yy h24:mi:ss");
            }
        };
        //BirthDateField.addStyleName(ValoTheme.DATEFIELD_TINY);
        BirthDateField.setResolution(BirthDateField.RESOLUTION_SEC);
        BirthDateField.setImmediate(true);
        //Label NullLabel = new Label(".");

        FormLayout FioVertLineForm = new FormLayout(
                //new Label()
          SecondNameField
                ,FirstNameField
                ,MiddleNameField
                ,BirthDateField
                //,new Label()
        );
        FioVertLineForm.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        //FioVertLineForm.setSizeUndefined();

        Label PersonalDataHeader = new Label();
        PersonalDataHeader.setContentMode(ContentMode.HTML);
        PersonalDataHeader.setValue(VaadinIcons.USER_CARD.getHtml() + "  Персональные данные");
        PersonalDataHeader.addStyleName(ValoTheme.LABEL_COLORED);
        PersonalDataHeader.addStyleName(ValoTheme.LABEL_SMALL);

        VerticalLayout FioVertLine = new VerticalLayout(
                PersonalDataHeader
                ,FioVertLineForm
        );


        FioVertLine.setComponentAlignment(PersonalDataHeader,Alignment.MIDDLE_LEFT);

        EmailField = new TextField();
        EmailField.setCaption("Электронная почта:");
        EmailField.setIcon(VaadinIcons.ENVELOPE);


        PhoneField = new TextField();
        PhoneField.setCaption("Номер телефона:");
        PhoneField.setIcon(VaadinIcons.PHONE);

        Label ContactDataHeader = new Label();
        ContactDataHeader.setContentMode(ContentMode.HTML);
        ContactDataHeader.setValue(VaadinIcons.LOCATION_ARROW_CIRCLE.getHtml() + "  Контактные данные");
        ContactDataHeader.addStyleName(ValoTheme.LABEL_COLORED);
        ContactDataHeader.addStyleName(ValoTheme.LABEL_SMALL);

        FormLayout PhoneVertLineForm = new FormLayout(
                //new Label()
                EmailField
                ,PhoneField
                //,new Label()
        );
        PhoneVertLineForm.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        //PhoneVertLineForm.setSizeUndefined();

        VerticalLayout PhoneVertLine = new VerticalLayout(
                ContactDataHeader
                ,PhoneVertLineForm
        );

        PhoneVertLine.setComponentAlignment(ContactDataHeader,Alignment.MIDDLE_LEFT);
        VerticalLayout UserTextDataSection = new VerticalLayout(
                FioVertLine
                ,PhoneVertLine
        );
        //PhoneVertLine.addStyleName(ValoTheme.LAYOUT_CARD);

        UserTextDataSection.setMargin(true);

        AvatarImage = new Image(null, new ClassResource("/pics/ava7.PNG"));
        AvatarImage.setHeight(120,Unit.PIXELS);
        AvatarImage.setWidth(120,Unit.PIXELS);
        VerticalLayout ImageLayout = new VerticalLayout(AvatarImage);
        ImageLayout.addStyleName(ValoTheme.LAYOUT_WELL);
        ImageLayout.setSizeUndefined();
        ImageLayout.setComponentAlignment(AvatarImage,Alignment.MIDDLE_CENTER);

        LoginLabel = new Label();
        //LoginLabel.addStyleName(ValoTheme.LABEL_LARGE);
        LoginLabel.addStyleName(ValoTheme.LABEL_COLORED);
        LoginLabel.setContentMode(ContentMode.HTML);
        LoginLabel.setValue(VaadinIcons.USER.getHtml() + "  " + "kalistrat");

        VerticalLayout LoginLabelLayout = new VerticalLayout(
                LoginLabel
        );
        LoginLabelLayout.setComponentAlignment(LoginLabel,Alignment.MIDDLE_CENTER);
        LoginLabelLayout.setSizeUndefined();;

        RatingLabel = new Label();
        RatingLabel.addStyleName(ValoTheme.LABEL_TINY);
        RatingLabel.setContentMode(ContentMode.HTML);
        RatingLabel.setValue(VaadinIcons.BAR_CHART.getHtml() + "  Рейтинг: " + "10.00");

        RegDateLabel = new Label();
        RegDateLabel.addStyleName(ValoTheme.LABEL_TINY);
        RegDateLabel.setContentMode(ContentMode.HTML);
        RegDateLabel.setValue(VaadinIcons.TIME_FORWARD.getHtml() + "  На сайте с: " + "01.01.2017");

        VerticalLayout RatingDateFromLayout = new VerticalLayout(
                new Label()
                ,RatingLabel
                ,RegDateLabel
        );
        //RatingDateFromLayout.setComponentAlignment(RatingLabel,Alignment.TOP_LEFT);
        //RatingDateFromLayout.setComponentAlignment(RegDateLabel,Alignment.TOP_CENTER);
        //RatingDateFromLayout.setSizeUndefined();

        VerticalLayout AvaLayout = new VerticalLayout(
                LoginLabelLayout
                ,new Label()
                ,ImageLayout
                ,RatingDateFromLayout
        );

        AvaLayout.setComponentAlignment(LoginLabelLayout,Alignment.TOP_CENTER);
        AvaLayout.setComponentAlignment(ImageLayout,Alignment.MIDDLE_CENTER);
        AvaLayout.setComponentAlignment(RatingDateFromLayout,Alignment.BOTTOM_CENTER);
        AvaLayout.setSizeUndefined();
        //AvaLayout.setComponentAlignment(LoginLabel,Alignment.TOP_CENTER);

        VerticalLayout LeftContentLayout = new VerticalLayout(
                AvaLayout
        );
        LeftContentLayout.setComponentAlignment(AvaLayout,Alignment.TOP_CENTER);
        LeftContentLayout.setMargin(new MarginInfo(true,false,false,false));

        Label GameDataHeader = new Label();
        GameDataHeader.setContentMode(ContentMode.HTML);
        GameDataHeader.setValue(VaadinIcons.PIE_BAR_CHART.getHtml() + "  Данные игрового профиля");
        GameDataHeader.addStyleName(ValoTheme.LABEL_COLORED);
        GameDataHeader.addStyleName(ValoTheme.LABEL_SMALL);

        UserBalanceField = new TextField();
        UserBalanceField.setCaption("Текущий баланс:");
        UserBalanceField.setIcon(VaadinIcons.CASH);

        UserCountGameField = new TextField();
        UserCountGameField.setCaption("Количество сыгранных игр:");
        UserCountGameField.setIcon(VaadinIcons.TASKS);

        FormLayout GameVertLineForm = new FormLayout(
                UserCountGameField
                ,UserBalanceField
        );
        GameVertLineForm.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);

        VerticalLayout GameVertLine = new VerticalLayout(
                GameDataHeader
                ,GameVertLineForm
        );

        UserTextDataSection.addComponent(GameVertLine);





        HorizontalSplitPanel UserDataSection = new HorizontalSplitPanel();
        UserDataSection.setHeight("1000px");
        UserDataSection.setWidth("800px");
        UserDataSection.setFirstComponent(LeftContentLayout);
        UserDataSection.setSecondComponent(UserTextDataSection);
        UserDataSection.setSplitPosition(25f,UNITS_PERCENTAGE);
        //UserDataSection.setMinSplitPosition(20f,UNITS_PERCENTAGE);
        //UserDataSection.setMaxSplitPosition(20f,UNITS_PERCENTAGE);
        //UserDataSection.addStyleName(ValoTheme.SPLITPANEL_LARGE);

        VerticalLayout ContentLayout = new VerticalLayout(UserDataSection);
        ContentLayout.setHeight("1000px");
        ContentLayout.setWidth("800px");
        ContentLayout.addStyleName(ValoTheme.LAYOUT_CARD);


        this.addComponent(new Label());
        this.addComponent(ContentLayout);
        this.addComponent(new Label());

        this.setComponentAlignment(ContentLayout,Alignment.MIDDLE_CENTER);
        //this.addStyleName(ValoTheme.LAYOUT_WELL);
        //this.setSizeUndefined();

    }
}
