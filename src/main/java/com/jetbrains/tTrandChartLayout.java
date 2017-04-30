package com.jetbrains;


import com.vaadin.data.Item;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalistrat on 05.09.2016.
 */
public class tTrandChartLayout extends HorizontalLayout {

    public String iUserName;
    public Integer iGameId;

    List<Double> XX = new ArrayList<Double>();
    List<Double> YY = new ArrayList<Double>();

    public tTrandChartLayout(int qGameId, String qUserName){
        this.iUserName = qUserName;
        this.iGameId = qGameId;

        this.GetTrendData();
        this.addComponent(new Graph("Изменение тренда","Шаги игры","Значение тренда",this.XX,this.YY,"red"));
        this.setSizeFull();

    }

    public void GetTrendData(){

        try {
            int s = 0;

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            String TrandValSql = "select @num := @num +1 row_number\n" +
                    ",gsp.trand_value\n" +
                    "from game_step gsp\n" +
                    "join (select @num:=0) num\n" +
                    "where gsp.game_id=?\n" +
                    "order by gsp.game_step_id";

            PreparedStatement TrandValStmt = Con.prepareStatement(TrandValSql);
            TrandValStmt.setInt(1,this.iGameId);

            ResultSet TrandValSqlRs = TrandValStmt.executeQuery();
            this.XX.add(0,0.0);
            this.YY.add(0,0.0);

            while (TrandValSqlRs.next()) {
                s=s+1;
                double StepId = (double) TrandValSqlRs.getInt(1);
                double StepVal = (double) TrandValSqlRs.getInt(2);
                this.XX.add(s,StepId);
                this.YY.add(s,StepVal);

            }
            Con.close();
        } catch (SQLException se3) {
            se3.printStackTrace();
        } catch (Exception e13) {
            e13.printStackTrace();
        }

    }

    public void refreshGraph(){
        this.removeAllComponents();
        this.XX.removeAll(this.XX);
        this.YY.removeAll(this.YY);
        this.GetTrendData();
        this.addComponent(new Graph("Изменение тренда","Шаги игры","Значение тренда",this.XX,this.YY,"RED"));
    }

}
