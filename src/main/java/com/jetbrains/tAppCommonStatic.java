package com.jetbrains;

/**
 * Created by kalistrat on 05.04.2017.
 */
public class tAppCommonStatic {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/conjuncture";
    public static final String USER = "gumbler";
    public static final String PASS = "tutunia";

    public static Integer StrToIntValue(String Sval) {
        int foo;
        String StringThatCouldBeANumberOrNot = "26263Hello"; //will throw exception
        String StringThatCouldBeANumberOrNot2 = "26263"; //will not throw exception
        try {
            return Integer.parseInt(Sval);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
