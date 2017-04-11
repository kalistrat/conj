package com.jetbrains;

import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 11.04.2017.
 */
public class tMainGameConnectLayout extends VerticalLayout {

    tConnectTree GameConnectTree;

    public  tMainGameConnectLayout(String eUserLogin){

        Image CubeImage = new Image(null, new ClassResource("/pics/red_dice1.png"));
        CubeImage.setHeight(120,Unit.PIXELS);
        CubeImage.setWidth(120,Unit.PIXELS);

        GameConnectTree = new tConnectTree();

        VerticalLayout LeftContentLayout = new VerticalLayout(
                CubeImage
                ,GameConnectTree
        );

        LeftContentLayout.setMargin(new MarginInfo(true,false,false,false));
        LeftContentLayout.setComponentAlignment(CubeImage,Alignment.MIDDLE_CENTER);
        LeftContentLayout.setSpacing(true);
        LeftContentLayout.setWidth("100%");

        VerticalLayout RightContentLayout = new VerticalLayout(
                new Label("Right Side")
        );



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
