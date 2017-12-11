package com.hmtmcse.shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by touhid on 3/01/2016.
 */
public class ShellRunner {


    public Map<String, String> executeCommand(String command, String[] env, File home, boolean isOut) throws JavaShellExceptionHandler {
        StringBuffer output = new StringBuffer();
        Map<String, String> returnValue = new HashMap<String, String>();
        Process process;
        Integer exitValue;
        try {
            process = Runtime.getRuntime().exec(command, env, home);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
                if (!isOut){
                    System.out.println(line);
                }
            }
            process.waitFor();
            System.out.println("response : " + process.exitValue());

            exitValue = process.exitValue();
            returnValue.put("response", output.toString());
            returnValue.put("exitCode", exitValue.toString());

        } catch (Exception e) {
            e.printStackTrace();
            throw new JavaShellExceptionHandler("Error From Execute Command : " + e.getMessage());
        }
        return returnValue;
    }


    public Map<String, String> executeCommandByHome(String command, File home) throws JavaShellExceptionHandler {
        return executeCommand(command, null, home, false);
    }

    public Map<String, String> executeCommandByHome(String command, File home, boolean output) throws JavaShellExceptionHandler {
        return executeCommand(command, null, home, true);
    }


}
