package com.hmtmcse;

import com.hmtmcse.advanced.db.MySQLTable;

import java.sql.SQLException;

/**
 * Created by Touhid Mia on 8/01/2015.
 */
public class RunFromHere {
    public static void main(String[] args) {

        try {
//            MySQLDatabase mySQLDatabase = new MySQLDatabase();
//            mySQLDatabase.create("touhidMia");

            MySQLTable mySQLTable = new MySQLTable("touhidmia");
            mySQLTable.create("test","name VARCHAR(255), email VARCHAR(255), phone VARCHAR(255)");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
