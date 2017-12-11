package com.hmtmcse.appsqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by touhid on 03-Jul-17.
 */
public class SQLiteConnection {

    Connection connection = null;
    Statement statement = null;
    private String JDBC_DRIVER_PACKAGE = "org.sqlite.JDBC";
    public String DATABASE_NAME_WITH_LOCATION = "word_book.db";
    private String DATABASE_URL = "jdbc:sqlite:" + DATABASE_NAME_WITH_LOCATION;

    public SQLiteConnection() throws SQLiteExceptionHandler {
        openConnection();
    }

    private void openConnection() throws SQLiteExceptionHandler {
        try {
            Class.forName(JDBC_DRIVER_PACKAGE);
            connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();
        } catch ( Exception e ) {
            throw new SQLiteExceptionHandler("Unable to Connect to Database");
        }
        System.out.println("Opened database successfully");
    }


    public void closeConnection() throws SQLiteExceptionHandler {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new SQLiteExceptionHandler("Unable to close Database Connection");
        }
    }
}
