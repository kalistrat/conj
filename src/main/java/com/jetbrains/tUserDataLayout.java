package com.jetbrains;

import com.vaadin.data.util.converter.Converter;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
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

    public tUserDataLayout(){

        SecondNameField = new TextField();
        SecondNameField.setCaption("Фамилия");

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

        Label PersonalDataHeader = new Label();
        PersonalDataHeader.setContentMode(ContentMode.HTML);
        PersonalDataHeader.setValue(VaadinIcons.USER_CARD.getHtml() + "  Личные данные");
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
        PhoneVertLineForm.setSizeUndefined();

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
        //UserTextDataSection.addStyleName();

        String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        FileResource resource = new FileResource(new File(basepath + "/VAADIN/themes/mytheme/pics/" + "ava7.PNG"));
        //Embedded AvatarImage = new Embedded(null,resource);
        Image AvatarImage = new Image(null, new ClassResource("/pics/ava7.PNG"));
        AvatarImage.setHeight(120,Unit.PIXELS);
        AvatarImage.setWidth(120,Unit.PIXELS);
        //VerticalLayout ImageLayout = new VerticalLayout(new Image(null, new ClassResource("/pics/ava7.PNG")));;
        VerticalLayout ImageLayout = new VerticalLayout(AvatarImage);

        ImageLayout.addStyleName(ValoTheme.LAYOUT_WELL);
        //ImageLayout.setHeight("80px");
        //ImageLayout.setWidth("80px");
        ImageLayout.setSizeUndefined();
        ImageLayout.setComponentAlignment(AvatarImage,Alignment.MIDDLE_CENTER);
        Button ImageButton = new Button();
        ImageButton.setIcon(new ClassResource("/pics/ava7.PNG"));

        VerticalLayout AvaLayout = new VerticalLayout(
                new Label("Чувачок")
                ,ImageLayout
                ,new Label("Баланс: 100р")
        );

        AvaLayout.setComponentAlignment(ImageLayout,Alignment.TOP_CENTER);


        HorizontalSplitPanel UserDataSection = new HorizontalSplitPanel();
        UserDataSection.setHeight("1000px");
        UserDataSection.setWidth("800px");
        UserDataSection.setFirstComponent(AvaLayout);
        UserDataSection.setSecondComponent(UserTextDataSection);
        UserDataSection.setSplitPosition(20f,UNITS_PERCENTAGE);
        //UserDataSection.setMinSplitPosition(20f,UNITS_PERCENTAGE);
        //UserDataSection.setMaxSplitPosition(20f,UNITS_PERCENTAGE);

        VerticalLayout ContentLayout = new VerticalLayout(UserDataSection);
        ContentLayout.setHeight("1000px");
        ContentLayout.setWidth("800px");
        ContentLayout.addStyleName(ValoTheme.LAYOUT_WELL);

        this.addComponent(ContentLayout);
        this.setComponentAlignment(ContentLayout,Alignment.MIDDLE_CENTER);

    }
}
