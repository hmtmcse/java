package com.hmtmcse.appsqlite;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by touhid on 03-Jul-17.
 */
public class SQLiteSQLQueryHelper extends SQLiteConnection{


    public SQLiteSQLQueryHelper() throws SQLiteExceptionHandler {
        super();
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

    public ResultSet sql(String sql){
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error Form SELECT " + "= " + e.getMessage());
            return null;
        }
    }

    public void createTable(String tableName, String tableFields){
        String sql = "CREATE TABLE " + tableName + " ( " + tableFields + " )";
        executor("createTable", sql);
    }


    private void executor(String from, String sql){
        try {
            int res = statement.executeUpdate(sql);
            System.out.println("Statement = " + res);
        } catch (SQLException e) {
            System.out.println("Error Form " + from + " = " + e.getMessage());
        }
    }

}
