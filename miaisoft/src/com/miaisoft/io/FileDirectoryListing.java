package com.miaisoft.io;

import java.io.File;

/**
 * Created by touhid on 15/07/2014.
 */
public class FileDirectoryListing {

    public static void main(String[] args) {
        String path = "D:\\touhid";

        File root = new File( path );
        File[] list = root.listFiles();

        for (File file : list ) {
            if (file.isDirectory() ) {
                System.out.println( "Dir:" + file.getName() );
            }else {
                System.out.println( "File:" + file.getName() );
            }
        }
    }



}
