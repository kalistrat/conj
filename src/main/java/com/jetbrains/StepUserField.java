package com.jetbrains;

import com.vaadin.ui.TextField;

import java.sql.*;

/**
 * Created by SemenovNA on 25.08.2016.
 */
public class StepUserField extends TextField {

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/conjuncture";
    static final private String USER = "gumbler";
    static final private String PASS = "tutunia";

    public TextField Field;
    public String StepingUser;
    public Integer iGameId;

    public StepUserField(int jGameId){
        this.iGameId = jGameId;
        this.Field = new TextField();
        this.StepingUser = GetStepingUserName(this.iGameId);
        this.setValue(String.valueOf(this.StepingUser));
    }

    public String GetStepingUserName(int qGameId){
        String StepingUserValue = null;

        try {
            Class.forName(JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(DB_URL, USER, PASS);

            CallableStatement StepUserStmt = Con.prepareCall("{? = call f_get_steping_user_name(?)}");
            StepUserStmt.registerOutParameter(1, Types.VARCHAR);
            StepUserStmt.setInt(2, qGameId);
            StepUserStmt.execute();
            StepingUserValue = StepUserStmt.getString(1);
            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }

        return StepingUserValue;
    }

    public void RefreshValue(){
        this.setValue(String.valueOf(this.GetStepingUserName(this.iGameId)));
    }


}
