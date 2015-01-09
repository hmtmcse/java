package com.hmtmcse;

import com.hmtmcse.advanced.http.HttpExceptionHandler;
import com.hmtmcse.advanced.http.HttpRequester;

import java.io.IOException;

/**
 * Created by Touhid Mia on 8/01/2015.
 */
public class RunFromHere {
    public static void main(String[] args) {

        HttpRequester httpRequester = new HttpRequester();
        try {
            httpRequester.GET("http://localhost:8080/GrailsForBeginner/restTest/get");
            httpRequester.DELETE("http://localhost:8080/GrailsForBeginner/restTest/delete");
            httpRequester.POST("http://localhost:8080/GrailsForBeginner/restTest/post", "name=touhid&email=cse");
            httpRequester.PUT("http://localhost:8080/GrailsForBeginner/restTest/put", "name=touhid&email=cse");

            httpRequester.download("http://download.tuxfamily.org/notepadplus/6.7.3/npp.6.7.3.Installer.exe", "C:\\Users\\Touhid Mia\\Desktop\\");
        }  catch (HttpExceptionHandler httpExceptionHandler) {
            System.out.println(httpExceptionHandler.getMessage());
        }


//        try {
//            MySQLDatabase mySQLDatabase = new MySQLDatabase();
//            mySQLDatabase.create("touhidmia");
//
//            MySQLTable mySQLTable = new MySQLTable("touhidmia");
//            mySQLTable.create("test","name VARCHAR(255), email VARCHAR(255), phone VARCHAR(255)");
//
//            MySQLQuery mySQLQuery = new MySQLQuery("touhidmia");
//            mySQLQuery.insertInto("test","name,email,phone","'Touhid Mia','hmtmcse@gmail.com','0000000000'");
//
//            mySQLQuery = new MySQLQuery("touhidmia");
//            ResultSet resultSet = mySQLQuery.select("test","*",null);
//            while(resultSet.next()){
//                System.out.println("Name : " + resultSet.getString("name"));
//                System.out.println("Email : " + resultSet.getString("email"));
//                System.out.println("Phone : " + resultSet.getString("phone"));
//            }
//            resultSet.close();
//
//            mySQLQuery = new MySQLQuery("touhidmia");
//            mySQLQuery.update("test","name = 'mia'","where email = 'hmtmcse@gmail.com'");
//
//            mySQLQuery = new MySQLQuery("touhidmia");
//            resultSet = mySQLQuery.select("test","*",null);
//            while(resultSet.next()){
//                System.out.println("Name : " + resultSet.getString("name"));
//                System.out.println("Email : " + resultSet.getString("email"));
//                System.out.println("Phone : " + resultSet.getString("phone"));
//            }
//            resultSet.close();
//
//            mySQLQuery = new MySQLQuery("touhidmia");
//            mySQLQuery.delete("test","where email = 'hmtmcse@gmail.com'");

//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
