package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 01.05.2017.
 */
public class tResultsGraphLayout extends VerticalLayout {

    int iGameId;
    String iUserLog;
    tTrandChartLayout iTrandChartLayout;
    tUserRatesChartsLayout iUserRatesChartsLayout;
    tAmountChartLayout iAmountChartLayout;

    public tResultsGraphLayout(int eGameId,String eUserLog){
        iGameId = eGameId;
        iUserLog = eUserLog;


        iTrandChartLayout = new tTrandChartLayout(iGameId, iUserLog);

        Label GameTrandHeader = new Label();
        GameTrandHeader.setContentMode(ContentMode.HTML);
        GameTrandHeader.setValue(VaadinIcons.CHART.getHtml() + " Изменение тренда");
        GameTrandHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameTrandHeader.addStyleName(ValoTheme.LABEL_COLORED);

        VerticalLayout TrandChartRootLayout = new VerticalLayout(
                iTrandChartLayout
        );
        TrandChartRootLayout.setWidth("100%");
        TrandChartRootLayout.setComponentAlignment(iTrandChartLayout, Alignment.MIDDLE_CENTER);


        iUserRatesChartsLayout = new tUserRatesChartsLayout(iGameId, iUserLog);

        Label RatesHeader = new Label();
        RatesHeader.setContentMode(ContentMode.HTML);
        RatesHeader.setValue(VaadinIcons.COINS.getHtml() + " Изменение ставок");
        RatesHeader.addStyleName(ValoTheme.LABEL_SMALL);
        RatesHeader.addStyleName(ValoTheme.LABEL_COLORED);

        VerticalLayout UserRatesChartsRootLayout = new VerticalLayout(
                iUserRatesChartsLayout
        );
        UserRatesChartsRootLayout.setWidth("100%");
        UserRatesChartsRootLayout.setComponentAlignment(iUserRatesChartsLayout, Alignment.MIDDLE_CENTER);

        iAmountChartLayout = new tAmountChartLayout(iGameId,iUserLog);

        Label AmountChartHeader = new Label();
        AmountChartHeader.setContentMode(ContentMode.HTML);
        AmountChartHeader.setValue(VaadinIcons.COIN_PILES.getHtml() + " Изменение игрового баланса");
        AmountChartHeader.addStyleName(ValoTheme.LABEL_SMALL);
        AmountChartHeader.addStyleName(ValoTheme.LABEL_COLORED);

        VerticalLayout AmountChartRootLayout = new VerticalLayout(
                iAmountChartLayout
        );
        AmountChartRootLayout.setWidth("100%");
        AmountChartRootLayout.setComponentAlignment(iAmountChartLayout, Alignment.MIDDLE_CENTER);


        VerticalLayout ContentLayout = new VerticalLayout(
                GameTrandHeader
                ,TrandChartRootLayout
                ,RatesHeader
                ,UserRatesChartsRootLayout
                ,AmountChartHeader
                ,AmountChartRootLayout
        );

        ContentLayout.setSpacing(true);
        addComponent(ContentLayout);
    }
}
