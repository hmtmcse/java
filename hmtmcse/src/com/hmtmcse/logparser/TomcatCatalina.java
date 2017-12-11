package com.hmtmcse.logparser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by touhid on 24/12/2015.
 */
public class TomcatCatalina {


    private static final String SKIP_DEFAULT_LOG = "^[A-Z][a-z]{2} \\d{2}";
    private static final String GOT_ERROR = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d+ \\[";
    private static final String END_THREAD_ERROR = "\\(Thread\\.java:\\d+\\)$";
    private static final String START_CAUSED_BY = "^Caused by:";
    private static final String END_BY_MORE = "\\d+ more$";

    private static boolean isEndLog = false;
    private static String tempLine = "";
    private static List<String> logList = new ArrayList<String>();
    static Integer lineNumber = 0;


    public static void addLing(String line) {
        if (!tempLine.equals("")){
            tempLine += "\n";
        }
        tempLine += lineNumber + " " + line;
        if (isEndLog) {
            logList.add(tempLine);
            tempLine = "";
            isEndLog = false;
        }
    }

    public static void reAddLing(String line) {
        int lastIndex = Math.max(0, logList.size() - 1);
        tempLine = logList.get(lastIndex);
        logList.remove(lastIndex);
        addLing(line);
    }

    public static void printLog() {
        for (int i = 0; i < logList.size(); i++) {
            System.out.println("===========================================================");
            System.out.println(logList.get(i));
            System.out.println("===========================================================");
        }
    }

    public static void parse(){
        File file = new File("C:\\Users\\touhid\\Desktop\\a\\catalina.out");
        if (!file.exists()) {
            System.out.println("File Not Exists");
        } else {

            try {
                BufferedReader catalinaReader = new BufferedReader(new FileReader(file));
                String line;
                Pattern pattern;
                Matcher matcher;
                boolean isLogFalse = false;
                while ((line = catalinaReader.readLine()) != null) {

                    lineNumber++;

                    pattern = Pattern.compile(SKIP_DEFAULT_LOG);
                    matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        isLogFalse = false;
                        continue;
                    }

                    pattern = Pattern.compile(GOT_ERROR);
                    matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        if (isLogFalse){
                            isEndLog = true;
                            addLing(line);
                        }else{
                            addLing(line);
                        }
                        isLogFalse = true;
                        continue;
                    }

                    pattern = Pattern.compile(END_THREAD_ERROR);
                    matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        isEndLog = true;
                        addLing(line);
                        isLogFalse = false;
                        continue;
                    }

                    pattern = Pattern.compile(START_CAUSED_BY);
                    matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        reAddLing(line);
                        isLogFalse = true;
                        continue;
                    }

                    pattern = Pattern.compile(END_BY_MORE);
                    matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        isEndLog = true;
                        addLing(line);
                        isLogFalse = false;
                        continue;
                    }

                    if (isLogFalse){
                        addLing(line);
                    }

                }

            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException Error : " + e.getMessage());
            } catch (IOException e) {
                System.out.println("IOException Error : " + e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        parse();
        printLog();
    }

}
