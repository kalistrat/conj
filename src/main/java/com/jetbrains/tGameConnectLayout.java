package com.jetbrains;


import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by kalistrat on 13.04.2017.
 */
public class tGameConnectLayout extends VerticalLayout {

    String iUserLog;
    Table ActiveGamesTable;
    Table ActivePlayersTable;
    IndexedContainer ActiveGamesContainer;
    IndexedContainer ActivePlayersContainer;

    public tGameConnectLayout(String eUserLog) {

        iUserLog = eUserLog;

        ActiveGamesTable = new Table();

        ActiveGamesTable.setColumnHeader(1, "№");
        ActiveGamesTable.setColumnHeader(2, "Дата<br/>создания");
        ActiveGamesTable.setColumnHeader(3, "Размер<br/>поля");
        ActiveGamesTable.setColumnHeader(4, "Число<br/>игроков");
        ActiveGamesTable.setColumnHeader(5, "Общий<br/>баланс");
        ActiveGamesTable.setColumnHeader(6, "");
        //ActiveGamesTable.setColumnIcon(7,VaadinIcons.CONNECT);

        ActiveGamesContainer = new IndexedContainer();

        ActiveGamesContainer.addContainerProperty(1, Integer.class, null);
        ActiveGamesContainer.addContainerProperty(2, String.class, null);
        ActiveGamesContainer.addContainerProperty(3, String.class, null);
        ActiveGamesContainer.addContainerProperty(4, Integer.class, null);
        ActiveGamesContainer.addContainerProperty(5, Double.class, null);
        ActiveGamesContainer.addContainerProperty(6, Button.class, null);
        GetActiveGamesData();

        ActiveGamesTable.setContainerDataSource(ActiveGamesContainer);
        ActiveGamesTable.setPageLength(6);


        ActiveGamesTable.setCellStyleGenerator(new Table.CellStyleGenerator() {
            @Override
            public String getStyle(Table components, Object itemId, Object columnId) {
                return "mytabletext";
            }
        });

        ActiveGamesTable.addStyleName(ValoTheme.TABLE_SMALL);
        ActiveGamesTable.addStyleName(ValoTheme.TABLE_COMPACT);
        ActiveGamesTable.addStyleName("mytabletext");



        ActivePlayersTable = new Table();

        ActivePlayersTable.setColumnHeader(1, "");
        ActivePlayersTable.setColumnHeader(2, "Логин");
        ActivePlayersTable.setColumnHeader(3, "Рейтинг");
        ActivePlayersTable.setColumnHeader(4, "Участие в<br/>других играх");
        ActivePlayersTable.setColumnHeader(5, "");

        ActivePlayersContainer = new IndexedContainer();

        ActivePlayersContainer.addContainerProperty(1, Embedded.class, null);
        ActivePlayersContainer.addContainerProperty(2, String.class, null);
        ActivePlayersContainer.addContainerProperty(3, Double.class, null);
        ActivePlayersContainer.addContainerProperty(4, String.class, null);
        ActivePlayersContainer.addContainerProperty(5, Button.class, null);

        GetActivePlayersData();

        ActivePlayersTable.setContainerDataSource(ActivePlayersContainer);
        ActivePlayersTable.setPageLength(3);


        ActivePlayersTable.setCellStyleGenerator(new Table.CellStyleGenerator() {
            @Override
            public String getStyle(Table components, Object itemId, Object columnId) {
                return "mytabletext";
            }
        });

        ActivePlayersTable.addStyleName(ValoTheme.TABLE_SMALL);
        ActivePlayersTable.addStyleName(ValoTheme.TABLE_COMPACT);
        ActivePlayersTable.addStyleName("mytabletext");

        Label ActiveGamesHeader = new Label();
        ActiveGamesHeader.setContentMode(ContentMode.HTML);
        ActiveGamesHeader.setValue(VaadinIcons.TABLE.getHtml() + " Активные игры");
        ActiveGamesHeader.addStyleName(ValoTheme.LABEL_SMALL);
        ActiveGamesHeader.addStyleName(ValoTheme.LABEL_COLORED);

        Label ActivePlayersHeader = new Label();
        ActivePlayersHeader.setContentMode(ContentMode.HTML);
        ActivePlayersHeader.setValue(VaadinIcons.TABLE.getHtml() + " Активные игроки");
        ActivePlayersHeader.addStyleName(ValoTheme.LABEL_SMALL);
        ActivePlayersHeader.addStyleName(ValoTheme.LABEL_COLORED);

        VerticalLayout ContentLayout = new VerticalLayout(
                ActiveGamesHeader
                ,ActiveGamesTable
                ,new Label()
                ,ActivePlayersHeader
                ,ActivePlayersTable
        );
        ContentLayout.setSpacing(true);


        this.addComponent(ContentLayout);

    }

    public void GetActiveGamesData() {

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String ActiveGamesSql = "select g.game_id\n" +
                    ",g.date_from\n" +
                    ",concat(art.area_size,'x',art.area_size) size\n" +
                    ",(\n" +
                    "select count(*)\n" +
                    "from game_player gp\n" +
                    "where gp.game_id=g.game_id\n" +
                    ") cnt_players\n" +
                    ",(\n" +
                    "select sum(gp.in_passiv_value)\n" +
                    "from game_player gp\n" +
                    "where gp.game_id=g.game_id\n" +
                    ") sum_players\n" +
                    "from game g\n" +
                    "join player p on p.player_id=g.create_player_id\n" +
                    "join area_type art on art.area_type_id=g.area_type_id\n" +
                    "where g.game_id > 40\n" +
                    "order by g.game_id";

            PreparedStatement ActiveGamesStmt = Con.prepareStatement(ActiveGamesSql);
            ResultSet ActiveGameslRes = ActiveGamesStmt.executeQuery();

            while (ActiveGameslRes.next()) {

                Item newItem = ActiveGamesContainer.getItem(ActiveGamesContainer.addItem());
                Button RequestButton = new Button("Запросить приглашение");
                RequestButton.addStyleName(ValoTheme.BUTTON_LINK);
                RequestButton.addStyleName(ValoTheme.BUTTON_TINY);
                RequestButton.setData(ActiveGameslRes.getInt(1));
                //RequestButton.setWidth("100px");
                RequestButton.setHeight("20px");


                newItem.getItemProperty(1).setValue(ActiveGameslRes.getInt(1));
                newItem.getItemProperty(2).setValue(df.format(new java.util.Date(ActiveGameslRes.getTimestamp(2).getTime())));
                newItem.getItemProperty(3).setValue(ActiveGameslRes.getString(3));
                newItem.getItemProperty(4).setValue(ActiveGameslRes.getInt(4));
                newItem.getItemProperty(5).setValue(ActiveGameslRes.getDouble(5));
                newItem.getItemProperty(6).setValue(RequestButton);

            }

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }


    }

    public void GetActivePlayersData() {


        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String ActivePlayersSql = "select p.player_log\n" +
                    ",ifnull(p.player_ava,'ava7.png')\n" +
                    ",p.rating\n" +
                    ",case when (\n" +
                    "select count(*)\n" +
                    "from game_player gp\n" +
                    "where gp.player_id=p.player_id\n" +
                    "and gp.is_active='Y'\n" +
                    ") != 0 then 'да' else 'нет' end\n" +
                    "from player p\n" +
                    "where p.player_log!='ADMIN'";

            PreparedStatement ActivePlayersStmt = Con.prepareStatement(ActivePlayersSql);
            ResultSet ActivePlayersRes = ActivePlayersStmt.executeQuery();

            while (ActivePlayersRes.next()) {

                Item newItem = ActivePlayersContainer.getItem(ActivePlayersContainer.addItem());
                Button RequestButton = new Button("Отправить приглашение");
                RequestButton.addStyleName(ValoTheme.BUTTON_LINK);
                RequestButton.addStyleName(ValoTheme.BUTTON_TINY);
                RequestButton.setData(ActivePlayersRes.getString(1));
                //RequestButton.setWidth("100px");
                RequestButton.setHeight("20px");

                Embedded IconImg = new Embedded(null, new ThemeResource("ava/"+ActivePlayersRes.getString(2)));
                IconImg.setWidth("40px");
                IconImg.setHeight("40px");

                newItem.getItemProperty(1).setValue(IconImg);
                newItem.getItemProperty(2).setValue(ActivePlayersRes.getString(1));
                newItem.getItemProperty(3).setValue(ActivePlayersRes.getDouble(3));
                newItem.getItemProperty(4).setValue(ActivePlayersRes.getString(4));
                newItem.getItemProperty(5).setValue(RequestButton);

            }

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
