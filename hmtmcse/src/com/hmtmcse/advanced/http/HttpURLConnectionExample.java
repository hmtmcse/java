package com.hmtmcse.advanced.http;

/**
 * Created by touhid on 23/05/2015.
 */
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Certificate;
import java.security.cert.CertificateFactory;

import javax.naming.Context;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HttpURLConnectionExample {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        System.out.println("Testing 1 - Send Http GET request");
        try {
            http.sendGet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "https://services.startrackexpress.com.au:7560/DMZExternalService/InterfaceServices/ExternalOps.serviceagent/OperationsEndpoint1";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
    }


}