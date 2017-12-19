package com.hmtmcse.bismillah;

import java.io.*;

public class TryCatch {

    public static void main(String[] args) throws CustomException {

        File file = new File("C:\\Users\\hmtmc\\Desktop\\git_log.txt1");
        if (!file.exists()){
            throw new CustomException("File Not Found");
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
        } catch (IOException e) {
            System.out.println("Exception From IO Operation");
        }finally {
           System.out.println("Text is: " + stringBuilder.toString());
        }
    }

}
