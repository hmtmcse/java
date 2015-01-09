package com.hmtmcse.advanced.db;

import java.sql.SQLException;

/**
 * Created by Touhid Mia on 9/01/2015.
 */
public class MySQLTable extends MySQLConnection {

    public MySQLTable(String databaseName) throws SQLException, ClassNotFoundException {
        super(databaseName);
    }

    public void create(String name, String nameAndType){
        String sql = "CREATE TABLE " + name + "( " + nameAndType + " )";
        executor("Create Table", sql);
    }

    private void executor(String from, String sql){
        try {
            int res = statement.executeUpdate(sql);
            System.out.println("Statement = " + res);
            closeConnection();
        } catch (SQLException e) {
            System.out.println("Error Form " + from + " = " + e.getMessage());
        }
    }

}
