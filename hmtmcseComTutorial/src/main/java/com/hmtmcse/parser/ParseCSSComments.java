package com.hmtmcse.parser;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseCSSComments {


    public static void main(String[] args) {

        File locationFile = new File("resources/style.css");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(locationFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String comments = stringBuilder.toString();

        String pattern = "\\/\\*[^*]*\\*+([^/*][^*]*\\*+)*\\/";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(comments);
        while (matcher.find()) {
            String comment = matcher.group();
            System.out.println("-----------------------------------------");
            System.out.println(comment);
            System.out.println("");
            getData(comment);
            System.out.println("-----------------------------------------");
            System.out.println("");
            System.out.println("");
        }
        System.out.println("Yes");
    }

    public static void getData(String text){
        System.out.println("Data");
        String pattern = "\\w+\\s*: ([\\w\\s\\d]+\\s*)";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
