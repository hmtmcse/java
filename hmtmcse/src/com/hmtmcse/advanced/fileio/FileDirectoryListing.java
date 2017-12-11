package com.hmtmcse.advanced.fileio;

import java.io.File;

/**
 * Created by touhid on 15/07/2014.
 */
public class FileDirectoryListing {

    public static void main(String[] args) {
        String path = "W:\\cloud\\Google\\English Learning\\E2B Words";

        File root = new File( path );
        File[] list = root.listFiles();

        for (File file : list ) {
            if (file.isDirectory() ) {
                System.out.println( "Dir:" + file.getName() );
            }else {
                System.out.println( "File:" + file.getName() );
                System.out.println( "Path:" + file.getAbsolutePath() );
            }
        }
    }



}
