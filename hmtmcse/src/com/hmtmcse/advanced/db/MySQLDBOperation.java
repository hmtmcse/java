package com.hmtmcse.advanced.db;

import java.sql.SQLException;

/**
 * Created by Touhid Mia on 8/01/2015.
 */
public class MySQLDBOperation extends MySQLConnection {

    public MySQLDBOperation() throws SQLException, ClassNotFoundException {
        super();
    }

    public void createDB(String dbname) {
        String sql = "CREATE DATABASE " + dbname + " default character set utf8 default collate utf8_general_ci";
        try {
            int res = statement.executeUpdate(sql);
            System.out.println("Statement = " + res);
            closeConnection();
        } catch (SQLException e) {
            System.out.println("Error Form createDB = " + e.getMessage());
        }
    }

    public void createTable() {

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
