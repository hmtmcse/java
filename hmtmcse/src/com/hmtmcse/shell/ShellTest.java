package com.hmtmcse.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Touhid Mia on 11/01/2016.
 */
public class ShellTest {

    public static void main(String[] args) {

        try {

            String[] command = new String[] {"/bin/sh", "-c", "cp -a '/opt/extreme2/target/WebCommander-2.1.6.war' '/wc-resource/binary-repo/2.1.6/app.war'"};
            Process process = Runtime.getRuntime().exec(command);
            System.out.println("===================================================");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
