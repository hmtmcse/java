package com.hmtmcse.advanced.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by touhid on 8/04/2015.
 */
public class ReadCSV {

    public static void main2(String[] args) {

        ReadCSV obj = new ReadCSV();
        obj.parse();

//        ReadCSV.main2();

    }

    public void parse() {
        String csvFile = "C:\\Users\\touhid\\Desktop\\a\\product.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                System.out.println("English = " + country[0] + "\n Bangla = " + country[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }


    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\touhid\\Desktop\\csv\\Finger_Print_Staff_info.csv"));
            String line = null;
            while (( line = input.readLine()) != null) {
                String[] fields = parseCSVLine(line);
                for ( int i = 0; i < fields.length; i++ ) {
                    System.out.println(fields[i]);
                }
            }
            input.close();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String[] parseCSVLine(String line) {
        // Create a pattern to match breaks
        Pattern p = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
        // Split input with the pattern
        String[] fields = p.split(line);
        for (int i = 0; i < fields.length; i++) {
            // Get rid of residual double quotes
            fields[i] = fields[i].replace("\"", "");
        }
        return fields;
    }


}
