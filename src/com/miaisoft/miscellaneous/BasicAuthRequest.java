package com.miaisoft.miscellaneous;


import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by touhid on 30/09/2014.
 */
public class BasicAuthRequest {

    public static void main(String[] args) {

        String _url = "http://localhost:8221/GrailsForBeginner/apiAuthTest/index";

        String userPass = "touhiddadfasf" + ":" + "touhid1";
        String encoded = Base64.encode(userPass.getBytes());
        try {
            URL url = new URL(_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(100000); //millisecond
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Authorization", "Basic "+encoded);
            int httpResponse = httpURLConnection.getResponseCode();
            System.out.println("HTTP Response = " + httpResponse);

            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer content = new StringBuffer();

            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }
            bufferedReader.close();
            System.out.println(content);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("UnKnown Host");
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
