package com.hmtmcse.advanced.fileio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileDirectoryListingRecursively {

    public void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk(f.getAbsolutePath());
            }
            else {
                String fname = f.getName();
                int pos = fname.lastIndexOf(".");
                if (pos > 0) {
                    fname = fname.substring(fname.lastIndexOf('.') + 1, fname.length());
                }
                if ( fname.equals("js") || fname.equals("css")){
                    String command = "java -jar yuicompressor-2.4.8.jar " + f.getAbsolutePath() + " -o " + f.getAbsolutePath();
                    System.out.println(command);
                    try {
                        Runtime.getRuntime().exec(command);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String path = in.nextLine();
        FileDirectoryListingRecursively fw = new FileDirectoryListingRecursively();
        fw.walk("C:\\Users\\Touhid Mia\\Desktop\\bootstrap");
    }


}
