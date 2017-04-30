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
    public tUserRatesTable iUserRatesTable;

    public tGameAreaLayout(int eGameId,String eUserLog){

        this.iGameId = eGameId;
        this.iUserLog = eUserLog;

        Label GameAreaHeader = new Label();
        GameAreaHeader.setContentMode(ContentMode.HTML);
        GameAreaHeader.setValue(VaadinIcons.GRID_SMALL.getHtml() + " Игровое поле");
        GameAreaHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameAreaHeader.addStyleName(ValoTheme.LABEL_COLORED);

        Label GameRatesHeader = new Label();
        GameRatesHeader.setContentMode(ContentMode.HTML);
        GameRatesHeader.setValue(VaadinIcons.BAR_CHART_V.getHtml() + " Ставки текущей игры");
        GameRatesHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameRatesHeader.addStyleName(ValoTheme.LABEL_COLORED);

        iGameAreaTable = new tGameAreaTable(iGameId,iUserLog);
        iUserRatesTable = new tUserRatesTable(iGameId,iUserLog);

        VerticalLayout ContentLayout = new VerticalLayout(
                GameAreaHeader
                ,iGameAreaTable
                ,new Label()
                ,GameRatesHeader
                ,iUserRatesTable
        );

        ContentLayout.setSpacing(true);


        addComponent(ContentLayout);
    }
}
