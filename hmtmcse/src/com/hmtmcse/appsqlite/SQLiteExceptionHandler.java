package com.hmtmcse.appsqlite;

/**
 * Created by touhid on 13/12/2015.
 */
public class SQLiteExceptionHandler extends Exception {

    public SQLiteExceptionHandler(){
        super("Unknown Exception");
    }

    public SQLiteExceptionHandler(String message){
        super(message);
    }

}
