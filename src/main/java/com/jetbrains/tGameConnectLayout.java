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
    Integer iActiveGameId;

    public tGameConnectLayout(String eUserLog,Integer eActiveGameId) {

        iUserLog = eUserLog;
        iActiveGameId = eActiveGameId;

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
        SetActiveGamesData();

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

        SetActivePlayersData();

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

    public void SetActiveGamesData() {

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String ActiveGamesSql = "select t.game_id\n" +
                    ",t.date_from\n" +
                    ",t.size\n" +
                    ",t.cnt_players\n" +
                    ",t.sum_players\n" +
                    "from (\n" +
                    "select g.game_id\n" +
                    ",g.date_from\n" +
                    ",concat(art.area_size,'x',art.area_size) size\n" +
                    ",count(*) cnt_players\n" +
                    ",sum(gap.in_passiv_value) sum_players\n" +
                    ",sum(\n" +
                    "if(p.player_log = ?,1,0)\n" +
                    ") is_have_a_part\n" +
                    "from game g\n" +
                    "join area_type art on art.area_type_id=g.area_type_id\n" +
                    "left join game_player gap on gap.game_id=g.game_id\n" +
                    "left join player p on p.player_id=gap.player_id\n" +
                    "where g.is_single_game=0\n" +
                    "and g.game_id > 40\n" +
                    "group by g.game_id\n" +
                    ",g.date_from\n" +
                    ",concat(art.area_size,'x',art.area_size) \n" +
                    "order by g.game_id desc\n" +
                    ") t\n" +
                    "where t.is_have_a_part=0";

            PreparedStatement ActiveGamesStmt = Con.prepareStatement(ActiveGamesSql);
            ActiveGamesStmt.setString(1,this.iUserLog);
            ResultSet ActiveGameslRes = ActiveGamesStmt.executeQuery();

            while (ActiveGameslRes.next()) {

                Item newItem = ActiveGamesContainer.getItem(ActiveGamesContainer.addItem());
                Button RequestButton = new Button("Запросить приглашение");
                RequestButton.addStyleName(ValoTheme.BUTTON_LINK);
                RequestButton.addStyleName(ValoTheme.BUTTON_TINY);
                RequestButton.setData(ActiveGameslRes.getInt(1));
                //RequestButton.setWidth("100px");
                RequestButton.setHeight("20px");

                RequestButton.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {

                            GameInviteAdd(iUserLog, (Integer) clickEvent.getButton().getData());
                            Notification.show("Приглашение создано:",
                                    "Ждите его подтверждения владельцем игры",
                                    Notification.Type.TRAY_NOTIFICATION);

                    }
                });


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

    public void SetActivePlayersData() {

        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String ActivePlayersSql = "select t.player_log\n" +
                    ",t.player_ava\n" +
                    ",t.rating\n" +
                    ",t.last_activity\n" +
                    "from (\n" +
                    "select p.player_log\n" +
                    ",ifnull(p.player_ava,'ava7.png') player_ava\n" +
                    ",p.rating\n" +
                    ",p.last_activity\n" +
                    ",(\n" +
                    "select count(*)\n" +
                    "from game_player gp\n" +
                    "where gp.player_id=p.player_id\n" +
                    "and gp.is_active=1\n" +
                    ") is_active\n" +
                    "from player p\n" +
                    "where p.player_log!='ADMIN'\n" +
                    "and p.player_log!=?\n" +
                    ") t\n" +
                    "where t.is_active=0";

            PreparedStatement ActivePlayersStmt = Con.prepareStatement(ActivePlayersSql);
            ActivePlayersStmt.setString(1,this.iUserLog);
            ResultSet ActivePlayersRes = ActivePlayersStmt.executeQuery();

            while (ActivePlayersRes.next()) {

                Item newItem = ActivePlayersContainer.getItem(ActivePlayersContainer.addItem());
                Button RequestButton = new Button("Отправить приглашение");
                RequestButton.addStyleName(ValoTheme.BUTTON_LINK);
                RequestButton.addStyleName(ValoTheme.BUTTON_TINY);
                RequestButton.setData(ActivePlayersRes.getString(1));
                //RequestButton.setWidth("100px");
                RequestButton.setHeight("20px");

                RequestButton.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        if (iActiveGameId != null) {
                            PlayerInviteAdd(iUserLog, (String) clickEvent.getButton().getData());
                            Notification.show("Приглашение создано:",
                                    "Ждите решения приглашаемого игрока",
                                    Notification.Type.TRAY_NOTIFICATION);
                        } else {
                            Notification.show("Ошибка создания приглашения:",
                                    "Вы не можете приглашать в игру, если Вы её не создали",
                                    Notification.Type.TRAY_NOTIFICATION);
                        }
                    }
                });

                Embedded IconImg = new Embedded(null, new ThemeResource("ava/"+ActivePlayersRes.getString(2)));
                IconImg.setWidth("40px");
                IconImg.setHeight("40px");

                newItem.getItemProperty(1).setValue(IconImg);
                newItem.getItemProperty(2).setValue(ActivePlayersRes.getString(1));
                newItem.getItemProperty(3).setValue(ActivePlayersRes.getDouble(3));
                newItem.getItemProperty(4).setValue(df.format(new java.util.Date(ActivePlayersRes.getTimestamp(4).getTime())));
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

    public void PlayerInviteAdd(String eUserFrom,String eUserTo){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement PlayerInviteStmt = Con.prepareCall("{call p_player_invate_add(?, ?)}");
            PlayerInviteStmt.setString(1, eUserFrom);
            PlayerInviteStmt.setString(2, eUserTo);
            PlayerInviteStmt.execute();

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }
    }

    public void GameInviteAdd(String eUserFrom,Integer eGameTo){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement GameInviteStmt = Con.prepareCall("{call p_game_invate_add(?, ?)}");
            GameInviteStmt.setString(1, eUserFrom);
            GameInviteStmt.setInt(2, eGameTo);
            GameInviteStmt.execute();

            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }
    }

    public void RefreshLayout(){

        ActiveGamesContainer.removeAllItems();
        ActivePlayersContainer.removeAllItems();
        SetActivePlayersData();
        SetActiveGamesData();

    }
}
