package com.jetbrains;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kalistrat on 03.05.2017.
 */
public class tGameLeftWindow extends Window {

    tLeftGameTable iLeftGameTable;
    int iGameId;
    String iUserLog;
    Button ExitButton;
    Button ContinieButton;
    TabSheet iGameMenuTabSheet;

    public tGameLeftWindow(int eGameId,String eUserLog,TabSheet eGameMenuTabSheet){

        iGameId = eGameId;
        iUserLog = eUserLog;
        iGameMenuTabSheet = eGameMenuTabSheet;

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

        ExitButton.setData(this);

        ExitButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                closeGamePlayer();
                UI.getCurrent().removeWindow((tGameLeftWindow) clickEvent.getButton().getData());
                iGameMenuTabSheet.removeTab(iGameMenuTabSheet.getTab(3));
                iGameMenuTabSheet.setData(0);
            }
        });

        ContinieButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().removeWindow((tGameLeftWindow) clickEvent.getButton().getData());
            }
        });

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

    public void closeGamePlayer(){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement CloseGamePlayerStmt = Con.prepareCall("{call p_close_game_player(?, ?)}");
            CloseGamePlayerStmt.setInt(1, iGameId);
            CloseGamePlayerStmt.setString(2, iUserLog);
            CloseGamePlayerStmt.execute();

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }
    }
}
