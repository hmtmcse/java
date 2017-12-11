package com.hmtmcse.habijabi;

import java.io.*;

/**
 * Created by touhid on 9/06/2016.
 */
public class IdGenerator {


    static String counterFile = "C:\\Users\\touhid\\Desktop\\sqa\\count";
    static String csvFile = "C:\\Users\\touhid\\Desktop\\sqa\\data.csv";
    static Integer numberOfRow = 5;


    public static String readAndReturnString(String location) {
        File file = new File(location);
        if (!file.exists()) {
            System.out.println("File Not Exists location");
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
            System.out.println("Exception From File Not Found readAndReturnString");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception From IO Operation readAndReturnString");
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static boolean writeStringInFile(String path, String content){
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            System.out.println("Done. path = " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        String count = readAndReturnString(counterFile);
        System.out.println(count);
        int total = Integer.parseInt(count.trim());
        int length = total - numberOfRow;
        int index;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ticket,email" + "\n");
        String line;
        for (index = total; index > length; index --){
            line = index + "," + index + "_em@gmail.com";
            System.out.println(line);
            stringBuilder.append(line + "\n");
        }
        writeStringInFile(counterFile, "" + (index --));
        writeStringInFile(csvFile, stringBuilder.toString());
    }

}
