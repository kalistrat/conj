package com.jetbrains;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.ValoTheme;

import java.sql.*;

/**
 * Created by SemenovNA on 25.08.2016.
 */
public class tUserRatesTable extends Table {

    public String iUserName;
    public Integer iGameId;
    public IndexedContainer RatesContainer;

    public tUserRatesTable(int jGameId, String jUserLog){


        setColumnHeader(1, "Цвет<br/>ставки");
        setColumnHeader(2, "Стоимость ставки");
        setColumnHeader(3, "Множитель ставки");
        setColumnHeader(4, "Количество ставок");

        this.iGameId=jGameId;
        this.iUserName=jUserLog;
        this.RatesContainer = new IndexedContainer();
        RatesContainer.addContainerProperty(1, Button.class, null);
        RatesContainer.addContainerProperty(2, Double.class, null);
        RatesContainer.addContainerProperty(3, Double.class, null);
        RatesContainer.addContainerProperty(4, Integer.class, null);

        GetContainerWithRates(this.iGameId,this.iUserName);
        setContainerDataSource(this.RatesContainer);
        setPageLength(this.RatesContainer.size());

        addStyleName(ValoTheme.TABLE_COMPACT);
        addStyleName(ValoTheme.TABLE_SMALL);

    }

    public void GetContainerWithRates(int qGameId,String qPlayerLog){

        try {
            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String FieldValSql = "select t.filed_color\n" +
                    ",t.field_price\n" +
                    ",t.field_value\n" +
                    ",(\n" +
                    "select count(*)\n" +
                    "from game_field gff\n" +
                    "join game_player gpl on gpl.game_player_id=gff.game_player_id\n" +
                    "join player pl on pl.player_id=gpl.player_id\n" +
                    "where gff.field_type_id=t.field_type_id\n" +
                    "and gff.game_id=t.game_id\n" +
                    "and pl.player_log=?\n" +
                    ") cnt_rates\n" +
                    "from\n" +
                    "(\n" +
                    "select gf.game_id\n" +
                    ",ft.field_type_id\n" +
                    ",ft.filed_color\n" +
                    ",ft.field_price\n" +
                    ",ft.field_value\n" +
                    "from game_field gf\n" +
                    "join field_type ft on ft.field_type_id=gf.field_type_id\n" +
                    "where gf.game_id=?\n" +
                    "group by gf.game_id\n" +
                    ",ft.field_type_id\n" +
                    ",ft.filed_color\n" +
                    ",ft.field_price\n" +
                    ",ft.field_value\n" +
                    ") t";

            PreparedStatement FieldValSqlStmt = Con.prepareStatement(FieldValSql);
            FieldValSqlStmt.setString(1,qPlayerLog);
            FieldValSqlStmt.setInt(2,qGameId);

            ResultSet FieldValSqlRs = FieldValSqlStmt.executeQuery();

            while (FieldValSqlRs.next()) {

                Item newItem = RatesContainer.getItem(RatesContainer.addItem());
                String FieldValColor = FieldValSqlRs.getString(1);
                Double FieldValPrice = FieldValSqlRs.getDouble(2);
                Double FieldValValue = FieldValSqlRs.getDouble(3);
                Integer FieldValCnt = FieldValSqlRs.getInt(4);

                Button ButtonField = new Button();
                ButtonField.addStyleName(FieldValColor);
                ButtonField.setHeight("25px");
                ButtonField.setWidth("50px");

                newItem.getItemProperty(1).setValue(ButtonField);
                newItem.getItemProperty(2).setValue(FieldValPrice);
                newItem.getItemProperty(3).setValue(FieldValValue);
                newItem.getItemProperty(4).setValue(FieldValCnt);

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

    public void RefreshData(){
        this.RatesContainer.removeAllItems();
        this.GetContainerWithRates(this.iGameId,this.iUserName);
        this.setContainerDataSource(this.RatesContainer);
    }
}
