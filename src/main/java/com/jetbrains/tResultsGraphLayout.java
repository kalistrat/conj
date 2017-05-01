package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.label.ContentMode;
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

    public tResultsGraphLayout(int eGameId,String eUserLog){
        iGameId = eGameId;
        iUserLog = eUserLog;


        iTrandChartLayout = new tTrandChartLayout(iGameId, iUserLog);

        Label GameTrandHeader = new Label();
        GameTrandHeader.setContentMode(ContentMode.HTML);
        GameTrandHeader.setValue(VaadinIcons.CHART.getHtml() + " Изменение тренда");
        GameTrandHeader.addStyleName(ValoTheme.LABEL_SMALL);
        GameTrandHeader.addStyleName(ValoTheme.LABEL_COLORED);

        iUserRatesChartsLayout = new tUserRatesChartsLayout(iGameId, iUserLog);

        Label RatesHeader = new Label();
        RatesHeader.setContentMode(ContentMode.HTML);
        RatesHeader.setValue(VaadinIcons.COINS.getHtml() + " Изменение ставок");
        RatesHeader.addStyleName(ValoTheme.LABEL_SMALL);
        RatesHeader.addStyleName(ValoTheme.LABEL_COLORED);


        VerticalLayout ContentLayout = new VerticalLayout(
                GameTrandHeader
                ,iTrandChartLayout
                ,RatesHeader
                ,iUserRatesChartsLayout
        );

        ContentLayout.setSpacing(true);
        addComponent(ContentLayout);
    }
}
