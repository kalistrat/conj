package com.jetbrains;


import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;


/**
 * Created by kalistrat on 13.04.2017.
 */
public class tGameConnectLayout extends VerticalLayout {

    String iUserLog;
    Table ActiveGamesTable;
    IndexedContainer ActiveGamesContainer;

    public tGameConnectLayout(String eUserLog) {

        iUserLog = eUserLog;

        ActiveGamesTable = new Table();

        ActiveGamesTable.setColumnHeader(1, "Номер игры");
        ActiveGamesTable.setColumnHeader(2, "Дата создания");
        ActiveGamesTable.setColumnHeader(3, "Создатель игры");
        ActiveGamesTable.setColumnHeader(4, "Размер поля");
        ActiveGamesTable.setColumnHeader(5, "Количество игроков");
        ActiveGamesTable.setColumnHeader(6, "Общий баланс игроков");
        ActiveGamesTable.setColumnHeader(7, "Время последнего хода");
        ActiveGamesTable.setColumnHeader(8, "Подключиться");

        ActiveGamesContainer = new IndexedContainer();

        ActiveGamesContainer.addContainerProperty(1, Integer.class, null);
        ActiveGamesContainer.addContainerProperty(2, Date.class, null);
        ActiveGamesContainer.addContainerProperty(3, String.class, null);
        ActiveGamesContainer.addContainerProperty(4, String.class, null);
        ActiveGamesContainer.addContainerProperty(5, Integer.class, null);
        ActiveGamesContainer.addContainerProperty(6, Double.class, null);
        ActiveGamesContainer.addContainerProperty(7, Timestamp.class, null);
        ActiveGamesContainer.addContainerProperty(8, Button.class, null);
        GetActiveGamesData();

        ActiveGamesTable.setContainerDataSource(ActiveGamesContainer);
        ActiveGamesTable.setSelectable(true);
        ActiveGamesTable.setPageLength(6);
        ActiveGamesTable.addStyleName(ValoTheme.TABLE_SMALL);
        ActiveGamesTable.addStyleName(ValoTheme.TABLE_COMPACT);

        Label ActiveGamesHeader = new Label();
        ActiveGamesHeader.setContentMode(ContentMode.HTML);
        ActiveGamesHeader.setValue(VaadinIcons.TABLE.getHtml() + " Активные игры");
        ActiveGamesHeader.addStyleName(ValoTheme.LABEL_SMALL);
        ActiveGamesHeader.addStyleName(ValoTheme.LABEL_COLORED);

        VerticalLayout ContentLayout = new VerticalLayout(
                ActiveGamesHeader
                ,ActiveGamesTable
        );
        ContentLayout.setSpacing(true);


        this.addComponent(ContentLayout);

    }

    public void GetActiveGamesData() {

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String ActiveGamesSql = "select g.game_id\n" +
                    ",g.date_from\n" +
                    ",p.player_log\n" +
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
                    ",g.last_activity_date\n" +
                    "from game g\n" +
                    "join player p on p.player_id=g.create_player_id\n" +
                    "join area_type art on art.area_type_id=g.area_type_id\n" +
                    "where g.game_id > 40\n" +
                    "order by g.game_id";

            PreparedStatement ActiveGamesStmt = Con.prepareStatement(ActiveGamesSql);
            ResultSet ActiveGameslRes = ActiveGamesStmt.executeQuery();

            while (ActiveGameslRes.next()) {

                Item newItem = ActiveGamesContainer.getItem(ActiveGamesContainer.addItem());

                Integer game_id_val = ActiveGameslRes.getInt(1);
                Date date_from_val = ActiveGameslRes.getDate(2);
                String player_log_val = ActiveGameslRes.getString(3);
                String area_size_val = ActiveGameslRes.getString(4);
                Integer cnt_players_val = ActiveGameslRes.getInt(5);
                Double sum_players_val = ActiveGameslRes.getDouble(6);
                Timestamp last_activity_date_val = ActiveGameslRes.getTimestamp(7);
                Button RequestButton = new Button("Подключиться");
                RequestButton.addStyleName(ValoTheme.BUTTON_LINK);
                RequestButton.addStyleName(ValoTheme.BUTTON_TINY);
                RequestButton.setData(game_id_val);

                newItem.getItemProperty(1).setValue(game_id_val);
                newItem.getItemProperty(2).setValue(date_from_val);
                newItem.getItemProperty(3).setValue(player_log_val);
                newItem.getItemProperty(4).setValue(area_size_val);
                newItem.getItemProperty(5).setValue(cnt_players_val);
                newItem.getItemProperty(6).setValue(sum_players_val);
                newItem.getItemProperty(7).setValue(last_activity_date_val);
                newItem.getItemProperty(8).setValue(RequestButton);

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
