package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;

/**
 * Created by kalistrat on 01.05.2017.
 */
public class tGameMembersTable extends Table {

    int iGameId;
    public IndexedContainer MembersContainer;

    public tGameMembersTable(int eGameId){

        setColumnHeader(1, "Имя игрока");
        setColumnHeader(2, "Символ на<br/>игровом поле");
        setColumnHeader(3, "Игровой баланс<br/>игрока");
        setColumnHeader(4, "Общее количество<br/>ставок");

        this.iGameId=eGameId;

        MembersContainer = new IndexedContainer();
        MembersContainer.addContainerProperty(1, String.class, null);
        MembersContainer.addContainerProperty(2, String.class, null);
        MembersContainer.addContainerProperty(3, Double.class, null);
        MembersContainer.addContainerProperty(4, Integer.class, null);

        GetMembersData(this.iGameId);
        setContainerDataSource(MembersContainer);
        setPageLength(MembersContainer.size());

        addStyleName(ValoTheme.TABLE_COMPACT);
        addStyleName(ValoTheme.TABLE_SMALL);


    }

    public void GetMembersData(int qGameId){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String MembersSql = "select p.player_log\n" +
                    ",concat(lower(substr(p.player_log,1,1))\n" +
                    ",trim(cast(gp.order_connect as CHAR(5)))) player_sym\n" +
                    ",gp.current_passiv_value\n" +
                    ",(\n" +
                    "select count(*)\n" +
                    "from game_field gf\n" +
                    "where gf.game_player_id=gp.game_player_id\n" +
                    ") cnt_rates\n" +
                    "from game g\n" +
                    "join game_player gp on gp.game_id=g.game_id\n" +
                    "join player p on p.player_id=gp.player_id\n" +
                    "where gp.is_active=1\n" +
                    "and gp.game_id=?";

            PreparedStatement MembersStmt = Con.prepareStatement(MembersSql);
            MembersStmt.setInt(1,qGameId);

            ResultSet MembersRs = MembersStmt.executeQuery();

            while (MembersRs.next()) {

                Item newItem = MembersContainer.getItem(MembersContainer.addItem());

                newItem.getItemProperty(1).setValue(MembersRs.getString(1));
                newItem.getItemProperty(2).setValue(MembersRs.getString(2));
                newItem.getItemProperty(3).setValue(MembersRs.getDouble(3));
                newItem.getItemProperty(4).setValue(MembersRs.getInt(4));

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
