package com.miaisoft.encryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by touhid on 8/01/2015.
 */
public class ShellCommand {

    public static void main(String[] args) {
        runSingle("ll");
    }

    public static void runSingle(String command){

    }

    public static void runBatch(String[] command){

    }


    public static void run(String single, String[] batch) {
        try {
            Process process;
            if (single != null){
                process = Runtime.getRuntime().exec(single);
            }else if (batch.length > 0){
                process = Runtime.getRuntime().exec(batch);
            }else{
                return;
            }

            BufferedReader consoleOutput;

            if (process.getErrorStream() != null){
                consoleOutput = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            }else if (process.getInputStream() != null){
                consoleOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            }else{
                return;
            }

            String outputString = null;
            while ((outputString = consoleOutput.readLine()) != null) {
                System.out.println(outputString);
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
        }
    }
}