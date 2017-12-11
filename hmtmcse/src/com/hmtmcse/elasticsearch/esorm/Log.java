package com.hmtmcse.elasticsearch.esorm;

/**
 * Created by touhid on 19/09/2016.
 */
public class Log {

    public static void bluePrintln(String message){
        System.out.println("\033[34m" + message);
    }

    public static void redPrintln(String message){
        System.out.println("\033[31m" + message);
    }

    public static void yellowPrintln(String message){
        System.out.println("\033[33m" + message);
    }

    public static void whitePrintln(String message){
        System.out.println("\033[37m" + message);
    }


    public static void error(String message){
        redPrintln("=====================================================================");
        whitePrintln(message);
        redPrintln("=====================================================================");
        whitePrintln("");
    }


    public static void info(String message){
        yellowPrintln("=====================================================================");
        whitePrintln(message);
        yellowPrintln("=====================================================================");
        whitePrintln("");
    }


}
