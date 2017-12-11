package com.hmtmcse.soap;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

/**
 * Created by mahmudur on 10/05/15.
 */
public class TwoWaySSL {
    public static void main(String[] args) {
        try{
            //set necessary keystore properties - using a p12 file
            System.setProperty("javax.net.ssl.keyStore","resource/new-store.p12");
            System.setProperty("javax.net.ssl.keyStorePassword","123456");
            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");


            //set necessary truststore properties - using JKS
            System.setProperty("javax.net.ssl.trustStore","resource/keystore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword","123456");
      //      System.setProperty("javax.net.ssl.trustStoreType","JKS");
            // register a https protocol handler  - this may be required for previous JDK versions
            System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");

            //connect to google
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSock = (SSLSocket) factory.createSocket("mail.google.com",443);

            //send HTTP get request
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sslSock.getOutputStream(), "UTF8"));
            wr.write("GET /mail HTTP/1.1\r\nhost: mail.google.com\r\n\r\n");
            wr.flush();

            // read response
            BufferedReader rd = new BufferedReader(new InputStreamReader(sslSock.getInputStream()));
            String string = null;

            while ((string = rd.readLine()) != null) {
                System.out.println(string);
                System.out.flush();
            }

            rd.close();
            wr.close();
            // Close connection.
            sslSock.close();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}