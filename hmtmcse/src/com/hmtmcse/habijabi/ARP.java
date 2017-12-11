package com.hmtmcse.habijabi;

import java.io.*;
import java.util.Random;

/**
 * Created by touhid on 9/06/2016.
 */
public class ARP {


    static String counterFile = "C:\\Users\\touhid\\Desktop\\data\\count";
    static String csvFile = "C:\\Users\\touhid\\Desktop\\data\\data.csv";
    static Integer numberOfRow = 2000;
    static String orderID = "12345";
    static String numberOfChild = "3";
    static  String addSpecialProduct = "Yes";
    static String discountCode[] = new String[]{
            "MNP54433",
            "MNA70648"
    };



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
        int length = total + numberOfRow;
        int index;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ticket,email" + "\n");
        String line;
        for (index = total; index < length; index ++){
            line = "FirstName_" + index + ",";
            line += "LastName_" + index + ",";
            line += "Address_" + index + ",";
            line += "City_" + index + ",";
            line += "3200" + ",";
            line += "1111111111" + ",";
            line += "myemail" + index + "@xyzf.com" + ",";
            line += "Mascot_123" + index + ",";
            line += "Victoria" + ",";
            line += "Australia" + ",";
            line +=  orderID + ",";
            line +=  numberOfChild + ",";
            line +=  "MNP31433,,";

            Random random = new Random();
            int i = random.nextInt(discountCode.length);
            line +=  discountCode[i] + ",";
            line +=  addSpecialProduct + ",";


            System.out.println(line);
            stringBuilder.append(line + "\n");
        }
        writeStringInFile(counterFile, "" + (index --));
        writeStringInFile(csvFile, stringBuilder.toString());
    }

}
