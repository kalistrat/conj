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
    public tGameMembersTable iGameMembersTable;
    public int iGameId;
    public String iUserLog;
    public tUserRatesTable iUserRatesTable;
    public tTrandChartLayout iTrandChartLayout;

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

        Label GameMembersHeader = new Label();
        GameMembersHeader.setContentMode(ContentMode.HTML);
        GameMembersHeader.setValue(VaadinIcons.GROUP.getHtml() + " Участники текущей игры");
        GameMembersHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameMembersHeader.addStyleName(ValoTheme.LABEL_COLORED);

        Label GameTrandHeader = new Label();
        GameTrandHeader.setContentMode(ContentMode.HTML);
        GameTrandHeader.setValue(VaadinIcons.CHART.getHtml() + " Изменение тренда");
        GameTrandHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameTrandHeader.addStyleName(ValoTheme.LABEL_COLORED);

        iGameAreaTable = new tGameAreaTable(iGameId,iUserLog);
        iUserRatesTable = new tUserRatesTable(iGameId,iUserLog);
        iGameMembersTable = new tGameMembersTable(iGameId);
        iTrandChartLayout = new tTrandChartLayout(iGameId, iUserLog);

        VerticalLayout ContentLayout = new VerticalLayout(
                GameTrandHeader
                ,iTrandChartLayout
                ,GameAreaHeader
                ,iGameAreaTable
                ,new Label()
                ,GameRatesHeader
                ,iUserRatesTable
                ,new Label()
                ,GameMembersHeader
                ,iGameMembersTable
        );

        ContentLayout.setSpacing(true);


        addComponent(ContentLayout);
    }
}
