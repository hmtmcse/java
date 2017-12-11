package com.hmtmcse;

import java.io.*;

/**
 * Created by touhid on 11-May-17.
 */
public class WhoisCheck {

    public static void main(String[] args) throws InterruptedException, IOException {

        File file = new File("siteList");
        BufferedReader catalinaReader = new BufferedReader(new FileReader(file));

        String domainName;
        StringBuffer output = new StringBuffer();
        while ((domainName = catalinaReader.readLine()) != null) {


            System.out.println(domainName);

            output.append(domainName + ",");
            Process process = Runtime.getRuntime().exec("whois " + domainName.trim());
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            String nameServer = "";
            while ((line = reader.readLine()) != null) {
                if (line.contains("Name Server:")) {
                    line = line.replace("Name Server:", "");
                    nameServer += line.trim() + " ";
                }
            }
            process.waitFor();
            if (!nameServer.equals("")){
                output.append(nameServer + "\n");
            }else{
                output.append("Not Found" + "\n");
            }


        }

        FileWriter fw = new FileWriter("lookup.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(output.toString());
        bw.close();
        fw.close();
        System.out.println(output.toString());

    }
}
