package com.jetbrains;

import com.vaadin.data.Property;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 11.04.2017.
 */
public class tMainGameConnectLayout extends VerticalLayout {

    tConnectTree GameConnectTree;
    public String iUserLog;
    public VerticalLayout RightContentLayout;


    public  tMainGameConnectLayout(String eUserLogin){

        iUserLog = eUserLogin;

        Image CubeImage = new Image(null, new ClassResource("/pics/c_page_blue2.png"));
        CubeImage.setHeight(100,Unit.PIXELS);
        CubeImage.setWidth(90,Unit.PIXELS);

        VerticalLayout CubeImageLayout = new VerticalLayout(CubeImage);
        CubeImageLayout.addStyleName(ValoTheme.LAYOUT_WELL);
        CubeImageLayout.setWidth("120px");
        CubeImageLayout.setHeight("120px");
        CubeImageLayout.setComponentAlignment(CubeImage,Alignment.MIDDLE_CENTER);

        Label LeftContentLabel= new Label();
        LeftContentLabel.setContentMode(ContentMode.HTML);
        LeftContentLabel.setValue(VaadinIcons.CONNECT.getHtml());
        LeftContentLabel.addStyleName(ValoTheme.LABEL_SMALL);
        LeftContentLabel.addStyleName(ValoTheme.LABEL_COLORED);
        LeftContentLabel.setSizeUndefined();

        GameConnectTree = new tConnectTree();

        GameConnectTree.addListener(new Property.ValueChangeListener() {

            public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
                if(event.getProperty().getValue() != null)
                {

                    if (event.getProperty().getValue().equals("Подключение к игре")){
                        //RightContentLayout.removeAllComponents();
                        RightContentLayout.removeAllComponents();
                        RightContentLayout.addComponent(new tGameConnectLayout(iUserLog));
                    }

                    if (event.getProperty().getValue().equals("Приглашения в игру")){
                        //RightContentLayout.removeAllComponents();
                        RightContentLayout.removeAllComponents();
                        RightContentLayout.addComponent(new tGameInvitesLayout());
                    }

                    if (event.getProperty().getValue().equals("Создание новой игры")){
                        //RightContentLayout.removeAllComponents();
                        RightContentLayout.removeAllComponents();
                        RightContentLayout.addComponent(new tNewGameFormLayout(iUserLog));
                    }

                }
            }
        });



        VerticalLayout LeftContentLayout = new VerticalLayout(
                LeftContentLabel
                ,CubeImageLayout
                ,GameConnectTree
        );

        LeftContentLayout.setMargin(new MarginInfo(true,false,false,false));
        LeftContentLayout.setComponentAlignment(CubeImageLayout,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setComponentAlignment(LeftContentLabel,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setSpacing(true);
        LeftContentLayout.setWidth("100%");

        tNewGameFormLayout oNewGameFormLayout = new tNewGameFormLayout(iUserLog);


        RightContentLayout = new VerticalLayout(
                oNewGameFormLayout
        );

        RightContentLayout.setMargin(true);




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



        this.addComponent(new Label());
        this.addComponent(ContentLayout);
        this.addComponent(new Label());

        this.setComponentAlignment(ContentLayout, Alignment.MIDDLE_CENTER);
    }

}
