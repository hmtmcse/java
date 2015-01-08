package com.hmtmcse.advanced.fileio;

import java.io.*;

/**
 * Created by touhid on 8/01/2015.
 */
public class Copy {


    public static void main(String[] args) {
        Copy copy = new Copy();
        try {
            copy.start("D:\\tomcat","C:\\Users\\touhid\\Desktop\\tom");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean start(String source, String destination) throws Exception {
        File sourceLocation = new File(source);
        File destinationLocation = new File(destination);

        if (!sourceLocation.exists()) {
            throw new Exception("Directory does not exist.");
        } else {
            recursiveCopy(sourceLocation, destinationLocation);
        }
        return true;
    }


    private boolean recursiveCopy(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdir();
                System.out.println("Directory copied from " + source + "  to " + destination);
            }

            String files[] = source.list();

            for (String file : files) {
                File sourceFile = new File(source, file);
                File destinationFile = new File(destination, file);
                recursiveCopy(sourceFile, destinationFile);
            }

        } else {
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("File copied from " + source + " to " + destination);
        }
        return true;
    }

}
