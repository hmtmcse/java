package com.hmtmcse.advanced.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Touhid Mia on 8/01/2015.
 */
public class MySQLConnection {
    public static String JDBC_DRIVER_PACKAGE = "com.mysql.jdbc.Driver";
    public static String SERVER_URL = "jdbc:mysql://localhost/";
    public static String SERVER_USER = "root";
    public static String SERVER_PASSWORD = "";

    Connection connection = null;
    Statement statement = null;

    public MySQLConnection(String selectDB) throws ClassNotFoundException, SQLException {
        SERVER_URL += selectDB;
        openConnection();
    }

    public MySQLConnection() throws ClassNotFoundException, SQLException {
        openConnection();
    }

    private void openConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER_PACKAGE); /* Register JDBC Driver **/
        connection = DriverManager.getConnection(SERVER_URL, SERVER_USER, SERVER_PASSWORD); //Open a connection
        statement = connection.createStatement(); //Build Query Statement
    }

    public void closeConnection() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
