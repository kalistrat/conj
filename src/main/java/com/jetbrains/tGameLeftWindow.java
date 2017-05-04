package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by kalistrat on 03.05.2017.
 */
public class tGameLeftWindow extends Window {

    tLeftGameTable iLeftGameTable;
    int iGameId;
    String iUserLog;
    Button ExitButton;
    Button ContinieButton;

    public tGameLeftWindow(int eGameId,String eUserLog){

        iGameId = eGameId;
        iUserLog = eUserLog;

        this.setIcon(VaadinIcons.EXIT_O);
        this.setCaption(" Выход из игры");

        Label LeftGameHeader = new Label(
                "В результате выхода из игры,\n"
              + "Ваш общий баланс будет увеличен.\n"
              + "Составляющие перечисляемой\n"
                        + "суммы приведены ниже:"
        );
        LeftGameHeader.setContentMode(ContentMode.PREFORMATTED);
        LeftGameHeader.addStyleName(ValoTheme.LABEL_SMALL);

        iLeftGameTable = new tLeftGameTable(iGameId,iUserLog);
        ExitButton = new Button("Покинуть игру");
        ContinieButton = new Button("Продолжить игру");
        ExitButton.setIcon(VaadinIcons.EXIT);
        ContinieButton.setIcon(VaadinIcons.MONEY_EXCHANGE);
        ExitButton.addStyleName(ValoTheme.BUTTON_TINY);
        ContinieButton.addStyleName(ValoTheme.BUTTON_TINY);

        HorizontalLayout ButtonsLayout = new HorizontalLayout(
                ExitButton
                ,ContinieButton
        );

        ButtonsLayout.setSizeUndefined();
        ButtonsLayout.setSpacing(true);

        VerticalLayout MessageLayout = new VerticalLayout(
                LeftGameHeader
                ,iLeftGameTable
        );
        MessageLayout.setSpacing(true);
        MessageLayout.setSizeUndefined();
        MessageLayout.setMargin(new MarginInfo(false,true,true,true));
        MessageLayout.setComponentAlignment(LeftGameHeader, Alignment.TOP_CENTER);
        MessageLayout.setComponentAlignment(iLeftGameTable, Alignment.MIDDLE_CENTER);
        MessageLayout.addStyleName(ValoTheme.LAYOUT_WELL);

        VerticalLayout WindowContentLayout = new VerticalLayout(
                MessageLayout
                ,ButtonsLayout
        );
        WindowContentLayout.setSizeUndefined();
        WindowContentLayout.setSpacing(true);
        WindowContentLayout.setMargin(true);
        WindowContentLayout.setComponentAlignment(ButtonsLayout, Alignment.BOTTOM_CENTER);

        this.setContent(WindowContentLayout);
        this.setSizeUndefined();
        this.setModal(true);
    }
}
