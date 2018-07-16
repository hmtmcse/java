package com.hmtmcse.gitflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GitCommandRunner {

    public static String[] environment;

    public static String[] getEnv(){
        Map<String, String> environment = new HashMap<String, String>(System.getenv());
        String[] envp = new String[environment.size()];
        int count = 0;
        for (Map.Entry<String, String> entry : environment.entrySet()) {
            envp[count++] = entry.getKey() + "=" + entry.getValue();
        }
        return envp;
    }

    public static void runToShell(String[] commands){
        runToShell(commands, getEnv(), null);
    }

    public static void runToShell(String[] commands, String location){
        runToShell(commands, getEnv(), new File(location));
    }

    public static void runToShell(String[] commands, String[] environment, File location){
        try {
            Process process = Runtime.getRuntime().exec(commands, environment, location);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
               System.out.println(line);
            }
            process.waitFor();
        } catch (IOException e) {
           System.out.println("IOException Error from RunToShell: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException Error from RunToShell: " + e.getMessage());
        }
    }


    public static void git(String command, String source){
        String[] commands = command.split(" ");
        runToShell(commands, source);
    }

}
