package com.hmtmcse.advanced.http;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Tou on 14/03/2015.
 */
public class RequestHeaderParse {

    public static void main(String[] args) {

        try {

            URL obj = new URL("http://13.0.40.1:8080/GrailsForBeginner/assets/grails_logo.png");
            URLConnection conn = obj.openConnection();
            Map<String, List<String>> map = conn.getHeaderFields();

            System.out.println("Printing Response Header...\n");

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.println("Key : " + entry.getKey()
                        + " ,Value : " + entry.getValue());
            }

            System.out.println("\nGet Response Header By Key ...\n");
            String server = conn.getHeaderField("Server");

            if (server == null) {
                System.out.println("Key 'Server' is not found!");
            } else {
                System.out.println("Server - " + server);
            }

            System.out.println("\n Done");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
