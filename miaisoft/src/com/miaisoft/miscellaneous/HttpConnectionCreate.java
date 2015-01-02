package com.miaisoft.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Created by touhid on 21/06/2014.
 */
public class HttpConnectionCreate {

    public static void main(String[] args) {
        HttpConnectionCreate httpConnectionCreate = new HttpConnectionCreate();
        httpConnectionCreate.getRequest("https://github.com/hmtmcse/java");

    }


    public void getRequest(String _url) {
        try {
            URL url = new URL(_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(1000); //millisecond
            httpURLConnection.setRequestMethod("GET");
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
