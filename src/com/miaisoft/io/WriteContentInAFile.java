package com.miaisoft.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by H.M.Touhid Mia on 6/16/2014.
 */
public class WriteContentInAFile {

    public static void main(String[] args) {
        try {

            String content = "Bangladesh is my Motherland!";
            String path = "h:\\files\\content.txt";

            File file = new File(path);

            // if file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
