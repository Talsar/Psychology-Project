package com.psychology.psychologyapp;

import android.os.AsyncTask;

import java.sql.* ;

/**
 * Created by oliverbammann on 29.11.15.
 * Edited by Carruth Topham 12/08/15
 */
public class DBConnection extends AsyncTask<Void, Integer, Boolean> {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    public DBConnection() {
        this.initializeConnection();
    }


    protected Boolean doInBackground(Void... voids) {
        this.initializeConnection();
        return null;
    }

    /**
     * Initiates the connection to the database
     */
    private void initializeConnection() {

        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String username = "java";
        String password = "java";

        Connection con;
        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cedar.humboldt.edu:1521:student",
                    username, password);

            Statement dateQueryStmt = con.createStatement();

            String dateQueryString = "select sysdate " + "from dual";

            ResultSet rS = dateQueryStmt.executeQuery(dateQueryString);

            rS.next();
            String todaysDate = rS.getString(1);
            this.setDate(todaysDate);

            dateQueryStmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}