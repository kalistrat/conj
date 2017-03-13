package com.jetbrains;

import com.vaadin.ui.HorizontalLayout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalistrat on 28.09.2016.
 */
public class g_results_chart extends HorizontalLayout {
    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/conjuncture";
    static final private String USER = "gumbler";
    static final private String PASS = "tutunia";

    public String iUserName;
    public Integer iGameId;

    List<Double> XX = new ArrayList<Double>();
    List<Double> YY = new ArrayList<Double>();

    public g_results_chart(int aGameId,String aUserName){
        this.iUserName = aUserName;
        this.iGameId = aGameId;

        this.GetResultsData();
        this.addComponent(new Graph("Изменение тренда","Шаги игры","Величина выигрыша",this.XX,this.YY,"red"));
        this.setSizeFull();

    }

    public void GetResultsData(){

        try {
            int s = 0;

            Class.forName(JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(DB_URL, USER, PASS);

            String ResultsValSql = "select @num:=@num+1 row_number\n" +
                    ",grs.game_step_result\n" +
                    "from game_step_results grs\n" +
                    "join game_player gpl on gpl.game_player_id=grs.game_player_id\n" +
                    "join player p on p.player_id=gpl.player_id\n" +
                    "join (select @num:=0) tnum\n" +
                    "where grs.game_id=?\n" +
                    "and p.player_log=?";

            PreparedStatement ResultsValStmt = Con.prepareStatement(ResultsValSql);
            ResultsValStmt.setInt(1,this.iGameId);
            ResultsValStmt.setString(2,this.iUserName);


            ResultSet ResultsValSqlRs = ResultsValStmt.executeQuery();
            this.XX.add(0,0.0);
            this.YY.add(0,0.0);

            while (ResultsValSqlRs.next()) {
                s=s+1;
                this.XX.add(s,(double) ResultsValSqlRs.getInt(1));
                this.YY.add(s,(double) ResultsValSqlRs.getInt(2));
            }
            Con.close();
        } catch (SQLException se3) {
            se3.printStackTrace();
        } catch (Exception e13) {
            e13.printStackTrace();
        }

    }

    public void refreshResGraph(){
        this.removeAllComponents();
        this.XX.removeAll(this.XX);
        this.YY.removeAll(this.YY);
        this.GetResultsData();
        this.addComponent(new Graph("Изменение тренда","Шаги игры","Величина выигрыша",this.XX,this.YY,"red"));
        //this.setSizeFull();
    }
}
