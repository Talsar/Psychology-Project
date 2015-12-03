package com.psychology.psychologyapp;

import android.os.AsyncTask;

import java.sql.* ;

/**
 * Created by oliverbammann on 29.11.15.
 */
public class DBConnection extends AsyncTask<Void, Integer, Boolean> {

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date = "Test String";


    public DBConnection() {
        //this.initializeConnection();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        this.initializeConnection();
        return null;
    }

    /**
     * Initiates the connection to the database
     */
    private void initializeConnection() {

        try {
            //DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        /*} catch (SQLException e) {
            e.printStackTrace();*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        String username = "d0203ec7";
        String password = "aikido90";

        Connection con;
        try {
            /*con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@cedar:1521:student",
                    username, password);*/

            /*con = DriverManager.getConnection(
                    "jdbc:mysql://w013ade6.kasserver.com/d0203ec7",
                    username, password);*/

            con = DriverManager.getConnection(
                    "jdbc:mysql://w013ade6.kasserver.com:3306/d0203ec7",
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
