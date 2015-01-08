package com.hmtmcse;

import com.hmtmcse.advanced.db.MySQLDBOperation;

import java.sql.SQLException;

/**
 * Created by Touhid Mia on 8/01/2015.
 */
public class RunFromHere {
    public static void main(String[] args) {

        try {
            MySQLDBOperation mySQLDBOperation = new MySQLDBOperation();
            mySQLDBOperation.createDB("touhidMia");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
