package com.hmtmcse.advanced.db;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Touhid Mia on 9/01/2015.
 */
public class MySQLQuery extends MySQLConnection {

    public MySQLQuery(String databaseName) throws SQLException, ClassNotFoundException {
        super(databaseName);
    }


    public void insertInto(String table, String column, String values){
        String sql = "INSERT INTO " + table + " ( " + column +" ) VALUES ( " + values + " )";
        executor("INSERT INTO", sql);
    }

    public void update(String table, String pair, String condition){
        String sql = "UPDATE " + table + " SET " + pair + " " + condition;
        executor("UPDATE", sql);
    }

    public void delete(String table, String where){
        String sql = "DELETE FROM " + table + " " + where;
        executor("DELETE FROM", sql);
    }

    public ResultSet select(String table, String select, String condition){
        String sql = "SELECT " + select + " FROM " + table + " " + (condition != null ? condition : "");
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error Form SELECT " + "= " + e.getMessage());
            return null;
        }
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
