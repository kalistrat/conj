package com.jetbrains;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 11.04.2017.
 */
public class tMainGameConnectLayout extends VerticalLayout {

    tConnectTree GameConnectTree;

    public  tMainGameConnectLayout(String eUserLogin){

        GameConnectTree = new tConnectTree();


        VerticalLayout LeftContentLayout = new VerticalLayout(
                GameConnectTree
        );
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
