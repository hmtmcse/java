package com.hmtmcse.appsqlite;

/**
 * Created by touhid on 03-Jul-17.
 */


public class SQLiteJDBC {


    public static void main( String args[] ) {
        try {
            SQLiteSQLQueryHelper sqLiteSQLQueryHelper = new SQLiteSQLQueryHelper();

            String tableRow = "id INTEGER PRIMARY KEY AUTOINCREMENT,";
            tableRow += "en text NULL,";
            tableRow += "bd text NULL,";
            tableRow += "en_ps text NULL,";
            tableRow += "en_synonym text NULL";
            sqLiteSQLQueryHelper.createTable("word", tableRow);

            tableRow = "id INTEGER PRIMARY KEY AUTOINCREMENT,";
            tableRow += "name text NULL,";
            tableRow += "description text NULL";
            sqLiteSQLQueryHelper.createTable("note", tableRow);


            tableRow = "word_id INTEGER NOT NULL,";
            tableRow += "note_id INTEGER NOT NULL";
            sqLiteSQLQueryHelper.createTable("word_note", tableRow);


        } catch (SQLiteExceptionHandler sqLiteExceptionHandler) {
            System.out.println(sqLiteExceptionHandler.getMessage());
        }
    }
}
