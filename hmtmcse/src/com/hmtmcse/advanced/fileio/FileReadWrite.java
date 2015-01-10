package com.hmtmcse.advanced.fileio;

import java.io.*;

/**
 * Created by Touhid Mia on 10/01/2015.
 */
public class FileReadWrite {

    public String readAndReturnString(String location) {
        /** Is File Exists */
        File file = new File(location);
        if (!file.exists()) {
            System.out.println("File Not Exists");
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception From File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception From IO Operation");
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public boolean writeStringInFile(String path, String content){
        try {
            File file = new File(path);
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
        return true;
    }

}
