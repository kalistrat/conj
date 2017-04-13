package com.jetbrains;

import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ImageRenderer;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 13.04.2017.
 */
public class tSelectGameAreaGrid extends MenuBar {

    public String SelectedAreaType = "";

    public tSelectGameAreaGrid(){

//        Image Area6x6Img = new Image(null, new ClassResource("/pics/GridAreaPic6x6.png"));
//        Area6x6Img.setHeight(80,Unit.PIXELS);
//        Area6x6Img.setWidth(80,Unit.PIXELS);
//
//        Image Area8x8Img = new Image(null, new ClassResource("/pics/GridAreaPic8x8.png"));
//        Area8x8Img.setHeight(80,Unit.PIXELS);
//        Area8x8Img.setWidth(80,Unit.PIXELS);
//
//        Image Area10x10Img = new Image(null, new ClassResource("/pics/GridAreaPic10x10.png"));
//        Area10x10Img.setHeight(80,Unit.PIXELS);
//        Area10x10Img.setWidth(80,Unit.PIXELS);



        ThemeResource a = new ThemeResource("pics/GridAreaPic6x6-100.png");
        ThemeResource b = new ThemeResource("pics/GridAreaPic8x8-100.png");
        ThemeResource c = new ThemeResource("pics/GridAreaPic10x10-100.png");

        this.addStyleName("mybarmenu");
        this.addStyleName(ValoTheme.MENUBAR_SMALL);

        MenuBar.Command mycommand = new MenuBar.Command() {
            MenuItem previous = null;

            public void menuSelected(MenuItem selectedItem) {
                SelectedAreaType = selectedItem.getText();

                if (previous != null)
                    previous.setStyleName(null);
                selectedItem.setStyleName("highlight");
                previous = selectedItem;
            }
        };

        this.addItem("6x6", a, mycommand);
        this.addItem("8x8", b, mycommand);
        this.addItem("10x10", c, mycommand);

        this.setHeight("100px");

    }
}
