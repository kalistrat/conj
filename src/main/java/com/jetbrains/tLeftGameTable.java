package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;

/**
 * Created by kalistrat on 03.05.2017.
 */
public class tLeftGameTable extends Table {

    IndexedContainer LeftGameTableContainer;
    int iGameId;
    String iUserLog;

    public tLeftGameTable(int eGameId,String eUserLog){

        iGameId = eGameId;
        iUserLog = eUserLog;

        LeftGameTableContainer = new IndexedContainer();
        LeftGameTableContainer.addContainerProperty(1, String.class, null);
        LeftGameTableContainer.addContainerProperty(2, Double.class, null);
        getLeftGameData();
        setContainerDataSource(LeftGameTableContainer);
        setColumnHeaderMode(ColumnHeaderMode.HIDDEN);
        setPageLength(LeftGameTableContainer.size());
        addStyleName(ValoTheme.TABLE_COMPACT);
        addStyleName(ValoTheme.TABLE_SMALL);

    }

    public void getLeftGameData(){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String LeftGameSql = "select a.cname\n" +
                    ",if (a.cname = 'Текущий игровой остаток',passiv_value,\n" +
                    "if (a.cname = 'Продажа игровых ставок',sale_rates_value,\n" +
                    "if (a.cname = 'Итого',total_value,null)\n" +
                    ")) cvalue\n" +
                    "from (select 'Текущий игровой остаток' cname\n" +
                    "union all\n" +
                    "select 'Продажа игровых ставок'\n" +
                    "union all\n" +
                    "select 'Итого'\n" +
                    ") a\n" +
                    "cross join (\n" +
                    "select t.passiv_value\n" +
                    ",t.sale_rates_value\n" +
                    ",t.passiv_value+t.sale_rates_value total_value\n" +
                    "from (\n" +
                    "select gp.game_player_id\n" +
                    ",ifnull(gp.current_passiv_value,0) passiv_value\n" +
                    ",sum(ft.field_price) sale_rates_value\n" +
                    "from game_field gf\n" +
                    "join field_type ft on ft.field_type_id = gf.field_type_id\n" +
                    "join game_player gp on gp.game_player_id = gf.game_player_id\n" +
                    "join player p on p.player_id=gp.player_id\n" +
                    "where gf.game_id=?\n" +
                    "and p.player_log=?\n" +
                    "group by gp.game_player_id\n" +
                    ",gp.current_passiv_value\n" +
                    ") t\n" +
                    ") b\n";

            PreparedStatement LeftGameStmt = Con.prepareStatement(LeftGameSql);
            LeftGameStmt.setInt(1,iGameId);
            LeftGameStmt.setString(2,iUserLog);

            ResultSet LeftGameRes = LeftGameStmt.executeQuery();

            while (LeftGameRes.next()) {
                Item newItem = LeftGameTableContainer.getItem(LeftGameTableContainer.addItem());
                newItem.getItemProperty(1).setValue(LeftGameRes.getString(1));
                newItem.getItemProperty(2).setValue(LeftGameRes.getDouble(2));
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
