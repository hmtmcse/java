package com.hmtmcse.advanced.parser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by touhid on 12/12/2016.
 */
public class GherkinCommentsParser {


    public static void main(String[] args) {


        File file = new File("D:\\codes\\miscelaneous\\ui_automated_testing\\AutoBill-JSCJ\\src\\test\\resources\\features\\app\\productAdd_KIT_SR_OTP.feature");
        if (!file.exists()) {
            System.out.println("File Not Exists");
        }

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            Boolean isStart = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (isStart) {
                    Pattern pattern = Pattern.compile("\\s*#\\s*(\\w+)\\s*:\\s*([a-zA-Z0-9,\\s_@-]+)");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        System.out.println("Key: " + matcher.group(1));
                        System.out.println("Value: " + matcher.group(2));

                    }
                }
                if (line.contains("#---") && !isStart){
                    isStart = true;
                }else if (line.contains("#---") && isStart){
                    break;
                }
            }



            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception From File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception From IO Operation");
            e.printStackTrace();
        }
    }

}
