package com.jetbrains;

import com.vaadin.ui.TextField;

import java.sql.*;

/**
 * Created by SemenovNA on 24.08.2016.
 */
public class BalanceField extends TextField {

    static final private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost/conjuncture";
    static final private String USER = "gumbler";
    static final private String PASS = "tutunia";

    public TextField Field;
    public Double CurrentValue;
    public Integer iGameId;
    public String iPlayerLog;

    public BalanceField(int jGameId, String jPlayerLog){

        this.iGameId = jGameId;
        this.iPlayerLog = jPlayerLog;
        this.Field = new TextField();
        this.CurrentValue = GetCurrentBalance(this.iGameId,this.iPlayerLog);
        this.setValue(String.valueOf(this.CurrentValue));
    }

    public Double GetCurrentBalance(int qGameId,String qPlayerLog){
        Double CurrentBalanceValue = null;

        try {
            Class.forName(JDBC_DRIVER);
            Connection Con = DriverManager.getConnection(DB_URL, USER, PASS);

            CallableStatement BalanceStmt = Con.prepareCall("{? = call f_get_current_balance(?, ?)}");
            BalanceStmt.registerOutParameter(1, Types.DECIMAL);
            BalanceStmt.setInt(2, qGameId);
            BalanceStmt.setString(3, qPlayerLog);
            BalanceStmt.execute();
            CurrentBalanceValue = BalanceStmt.getDouble(1);
            Con.close();

        } catch (SQLException se3) {
            //Handle errors for JDBC
            se3.printStackTrace();
        } catch (Exception e13) {
            //Handle errors for Class.forName
            e13.printStackTrace();
        }

        return CurrentBalanceValue;
    }

    public void RefreshValue(){
        this.setValue(String.valueOf(this.GetCurrentBalance(this.iGameId,this.iPlayerLog)));
    }
}
