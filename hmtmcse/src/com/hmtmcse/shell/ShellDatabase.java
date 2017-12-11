package com.hmtmcse.shell;

/**
 * Created by Touhid Mia on 03/01/2016.
 */
public class ShellDatabase {

    private String databaseUser = null;
    private String databasePass = null;



    public ShellDatabase(String _databaseUser, String _databasePass){
        databaseUser = _databaseUser;
        databasePass = _databasePass;
    }

    public ShellDatabase(){

    }


    public boolean mysqlDump(String dbName, String location){
        return true;
    }


    public boolean mysqlImport(String dbName, String location){
        return true;
    }

}
