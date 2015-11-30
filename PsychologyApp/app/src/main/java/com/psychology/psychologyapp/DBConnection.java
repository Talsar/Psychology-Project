package com.psychology.psychologyapp;

import java.sql.* ;

/**
 * Created by oliverbammann on 29.11.15.
 */
public class DBConnection {


    public DBConnection() {
        this.initializeConnection();
    }

    private void initializeConnection() {

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String username = "psych";
        String password = "vakna25^";

        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cedar:1521:student",
                    username, password);

            //Statement dateQueryStmt = con.createStatement();

            //dateQueryStmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
