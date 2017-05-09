package com.jetbrains;

import com.vaadin.event.UIEvents;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
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
        VerticalLayout GameAreaTableLayout = new VerticalLayout(
                iGameAreaTable
        );
        GameAreaTableLayout.setWidth("100%");
        GameAreaTableLayout.setComponentAlignment(iGameAreaTable, Alignment.MIDDLE_CENTER);

        iUserRatesTable = new tUserRatesTable(iGameId,iUserLog);
        VerticalLayout UserRatesTableLayout = new VerticalLayout(
                iUserRatesTable
        );
        UserRatesTableLayout.setWidth("100%");
        UserRatesTableLayout.setComponentAlignment(iUserRatesTable, Alignment.MIDDLE_CENTER);

        iGameMembersTable = new tGameMembersTable(iGameId);
        VerticalLayout GameMembersTableLayout = new VerticalLayout(
                iGameMembersTable
        );
        GameMembersTableLayout.setWidth("100%");
        GameMembersTableLayout.setComponentAlignment(iGameMembersTable, Alignment.MIDDLE_CENTER);

        iTrandChartLayout = new tTrandChartLayout(iGameId, iUserLog);
        VerticalLayout TrandChartLayout = new VerticalLayout(
                iTrandChartLayout
        );
        TrandChartLayout.setWidth("100%");
        TrandChartLayout.setComponentAlignment(iTrandChartLayout, Alignment.MIDDLE_CENTER);

        VerticalLayout ContentLayout = new VerticalLayout(
                GameTrandHeader
                ,TrandChartLayout
                ,GameAreaHeader
                ,GameAreaTableLayout
                ,new Label()
                ,GameRatesHeader
                ,UserRatesTableLayout
                ,new Label()
                ,GameMembersHeader
                ,GameMembersTableLayout
        );

        ContentLayout.setSpacing(true);


        addComponent(ContentLayout);

        UI.getCurrent().addPollListener(new UIEvents.PollListener() {
            @Override
            public void poll(UIEvents.PollEvent pollEvent) {
                iGameAreaTable.AreaContainerRefresh();
                iTrandChartLayout.refreshGraph();
                iGameMembersTable.refreshData();
                iUserRatesTable.RefreshData();
            }
        });
    }
}
