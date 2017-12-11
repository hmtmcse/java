package com.hmtmcse.advanced.db;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by touhid on 10/12/2015.
 */
public class Main {



    public static void convertToCsv(ResultSet rs) throws SQLException, FileNotFoundException {
        PrintWriter csvWriter = new PrintWriter(new File("C:\\Users\\touhid\\Desktop\\a\\whatever.csv")) ;
        ResultSetMetaData meta = rs.getMetaData() ;
        int numberOfColumns = meta.getColumnCount() ;
        String dataHeaders = "\"" + meta.getColumnName(1) + "\"" ;
        for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) {
            dataHeaders += ",\"" + meta.getColumnName(i) + "\"" ;
        }
        csvWriter.println(dataHeaders) ;
        while (rs.next()) {
            String row = "\"" + rs.getString(1) + "\""  ;
            for (int i = 2 ; i < numberOfColumns + 1 ; i ++ ) {
                row += ",\"" + rs.getString(i) + "\"" ;
            }
            csvWriter.println(row) ;
        }
        csvWriter.close();
    }

    public static void main(String[] args) {
        try {

//            SchemaCreator schemaCreator = new SchemaCreator("wc_init_sql");
//            schemaCreator.getDatabaseSchema();


//            SchemaChecker schemaChecker = new SchemaChecker("wc_init_sql");
//            schemaChecker.getDatabaseSchema();

            MySQLQuery mySQLQuery = new MySQLQuery("ab_sql");
            ResultSet resultSet = mySQLQuery.sql("");


            if (resultSet != null){
                convertToCsv(resultSet);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
