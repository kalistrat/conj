package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 28.04.2017.
 */
public class tGameAreaLayout extends VerticalLayout {

    public tGameAreaTable iGameAreaTable;
    public int iGameId;
    public String iUserLog;

    public tGameAreaLayout(int eGameId,String eUserLog){

        this.iGameId = eGameId;
        this.iUserLog = eUserLog;

        Label GameAreaHeader = new Label();
        GameAreaHeader.setContentMode(ContentMode.HTML);
        GameAreaHeader.setValue(VaadinIcons.GRID_SMALL.getHtml() + " Игровое поле");
        GameAreaHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameAreaHeader.addStyleName(ValoTheme.LABEL_COLORED);

        iGameAreaTable = new tGameAreaTable(iGameId,iUserLog);

        VerticalLayout ContentLayout = new VerticalLayout(
                GameAreaHeader
                ,iGameAreaTable
        );

        addComponent(ContentLayout);
    }
}
