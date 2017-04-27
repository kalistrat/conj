package com.jetbrains;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.sql.*;

/**
 * Created by kalistrat on 27.04.2017.
 */
public class tGameRunningLayout extends VerticalLayout {

    public int iGameId;

    public tGameRunningLayout(int eGameId){

        this.iGameId = eGameId;
        VerticalLayout ContentLayout = new VerticalLayout(
          new Label("Это игра за нумером: " + String.valueOf(this.iGameId))
        );
        this.addComponent(ContentLayout);

    }

    public static int getLastUserGame(String eUserLog){
        int gameid = 0;

        try {

            Class.forName(tAppCommonStatic.JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(
                    tAppCommonStatic.DB_URL
                    , tAppCommonStatic.USER
                    , tAppCommonStatic.PASS
            );

            CallableStatement CurrentGameStmt = Con.prepareCall("{? = call f_current_game_by_user(?)}");
            CurrentGameStmt.registerOutParameter (1, Types.INTEGER);
            CurrentGameStmt.setString(2, eUserLog);

            CurrentGameStmt.execute();
            gameid = CurrentGameStmt.getInt(1);
            //System.out.println(gameid);
            Con.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return gameid;
    }
}
