package com.hmtmcse.advanced.db.ex;

/**
 * Created by touhid on 10/12/2015.
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class SchemaDetailsTest {


    public static void main(String args[]) throws Exception {
        String databaseName = "abc";
        String userName = "root";
        String password = "";
        String mySQLPort = "3306";
        String hostUrl = "127.0.0.1";
        // Setup the connection with the DB
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + hostUrl
                + ":" + mySQLPort, userName, password);
        // --- LISTING DATABASE SCHEMA NAMES ---
        ResultSet resultSet = conn.getMetaData().getCatalogs();
//        while (resultSet.next()) {
//            System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
//        }
//        resultSet.close();
        // --- LISTING DATABASE TABLE NAMES ---
        String[] types = { "TABLE" };
        resultSet = conn.getMetaData()
                .getTables(databaseName, null, "%", types);
        String tableName = "";
        while (resultSet.next()) {
            tableName = resultSet.getString(3);
            System.out.println("==================== " + tableName + " ====================");
        }
        resultSet.close();
        // --- LISTING DATABASE COLUMN NAMES ---
        DatabaseMetaData meta = conn.getMetaData();
        resultSet = meta.getColumns(databaseName, null, tableName, "%");

        while (resultSet.next()) {
            String COLUMN_NAME  = resultSet.getString("COLUMN_NAME");
            String COLUMN_SIZE = resultSet.getString("COLUMN_SIZE");
            String TYPE_NAME = resultSet.getString("TYPE_NAME");
            String COLUMN_DEF = resultSet.getString("COLUMN_DEF");
            String IS_AUTOINCREMENT  = resultSet.getString("IS_AUTOINCREMENT");
            String IS_NULLABLE   = resultSet.getString("IS_NULLABLE");

            System.out.print(COLUMN_NAME);
            System.out.print(" " + COLUMN_DEF);
            System.out.print(" " + COLUMN_SIZE);
            System.out.print(" " + TYPE_NAME);
            System.out.print(" " + IS_AUTOINCREMENT);
            System.out.print(" " + IS_NULLABLE);


            System.out.println(" ");

//            System.out.println("Column Name of table " + tableName + " = "
//                    + resultSet.getString(4));
        }

        System.out.println(" ");
    }
}
