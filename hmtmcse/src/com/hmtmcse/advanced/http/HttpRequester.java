package com.hmtmcse.advanced.http;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by Touhid Mia on 9/01/2015.
 */
public class HttpRequester {

    public int READ_TIME = 1000;
    public String USER_AGENT = "Mozilla/5.0";
    public String CONTEXT_TYPE = "application/x-www-form-urlencoded";


    private final String POST = "POST";
    private final String GET = "GET";
    private final String PUT = "PUT";
    private final String DELETE = "DELETE";

    private final int BUFFER_SIZE = 1024;

    //Error Message
    private final String INVALID_URL = "Invalid URL OR Server Down!";
    private final String TIME_OUT = "Connection TimeOut!";


    private String contentAsText(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            stringBuilder.append(line);
        }
        in.close();
        return stringBuilder.toString();
    }

    private String contentAsFile(String path, InputStream inputStream) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        int bytesRead = -1;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.close();
        return "";
    }


    private void requestMaker(String protocol, String _url, String params, String path) throws HttpExceptionHandler {
        try {
            URL url = new URL(_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(READ_TIME);
            httpURLConnection.setRequestProperty("Content-Type", CONTEXT_TYPE);
            httpURLConnection.setRequestProperty("User-Agent", USER_AGENT); //Add request header

            if (protocol.equals(POST) || protocol.equals(PUT)) {
                httpURLConnection.setRequestMethod(protocol);
                httpURLConnection.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(params);
                wr.flush();
                wr.close();
            } else {
                httpURLConnection.setRequestMethod(protocol);
            }
            String response = "";
            if (httpResponseCodeChecker(httpURLConnection.getResponseCode())) {
                if ((path == null) || (path.equals(""))){
                    response = contentAsText(httpURLConnection.getInputStream());
                }else{
                    String fileName = "";
                    String disposition = httpURLConnection.getHeaderField("Content-Disposition");
                    if (disposition != null) {
                        int index = disposition.indexOf("filename=");
                        if (index > 0) {
                            fileName = disposition.substring(index + 10, disposition.length() - 1);
                        }
                    } else {
                        fileName = _url.substring(_url.lastIndexOf("/") + 1, _url.length());
                    }
                    contentAsFile(path + File.separator + fileName,httpURLConnection.getInputStream());
                    response = "File Downloaded";
                }
            }
            System.out.println(response);
        } catch (ConnectException c) {
            throw new HttpExceptionHandler(TIME_OUT);
        }catch (SocketTimeoutException s){
            throw new HttpExceptionHandler(INVALID_URL);
        }catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public void download(String url,String savePath) throws HttpExceptionHandler {
        requestMaker(GET, url, null, savePath);
    }

    public void GET(String url) throws HttpExceptionHandler {
        requestMaker(GET, url, null, null);
    }

    public void POST(String url, String params) throws HttpExceptionHandler {
        requestMaker(POST, url, params, null);
    }

    public void PUT(String url, String params) throws HttpExceptionHandler {
        requestMaker(PUT, url, params, null);
    }

    public void DELETE(String url) throws HttpExceptionHandler {
        requestMaker(DELETE, url, null, null);
    }


    private boolean httpResponseCodeChecker(int statusCode) throws HttpExceptionHandler {
        switch (statusCode) {
            case 200:
                return true;
            case 500:
                throw new HttpExceptionHandler("Internal Server Error!");
            case 404:
                throw new HttpExceptionHandler("Not Found!");
            case 502:
                throw new HttpExceptionHandler("Bad Gateway!");
            case 503:
                throw new HttpExceptionHandler("Service Unavailable!");
            case 504:
                throw new HttpExceptionHandler("Gateway Timeout!");
            case 405:
                throw new HttpExceptionHandler("Method Not Allowed!");
            default:
                throw new HttpExceptionHandler("Unknown HTTP Error!");
        }
    }
}
