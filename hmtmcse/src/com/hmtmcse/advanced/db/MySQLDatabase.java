package com.hmtmcse.advanced.db;

import java.sql.SQLException;

/**
 * Created by Touhid Mia on 8/01/2015.
 */
public class MySQLDatabase extends MySQLConnection {

    public MySQLDatabase() throws SQLException, ClassNotFoundException {
        super();
    }

    public void create(String dbname) {
        String sql = "CREATE DATABASE " + dbname + " default character set utf8 default collate utf8_general_ci";
        try {
            int res = statement.executeUpdate(sql);
            System.out.println("Statement = " + res);
            closeConnection();
        } catch (SQLException e) {
            System.out.println("Error Form createDB = " + e.getMessage());
        }
    }

    public void drop(String dbname) {
        String sql = "DROP DATABASE " + dbname ;
        try {
            int res = statement.executeUpdate(sql);
            System.out.println("Statement = " + res);
            closeConnection();
        } catch (SQLException e) {
            System.out.println("Error Form dropDB = " + e.getMessage());
        }
    }
}
