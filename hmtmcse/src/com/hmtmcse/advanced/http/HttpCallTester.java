package com.hmtmcse.advanced.http;

/**
 * Created by touhid on 23/05/2015.
 */
public class HttpCallTester {

    public static void main(String[] args) {
        HttpRequester httpRequester = new HttpRequester();
        httpRequester.READ_TIME = 1800000;
        try {
            httpRequester.download("https://codeload.github.com/hmtmcse/php/zip/master","C:\\Users\\Touhid Mia\\Desktop\\django-admin-bootstrap-master\\asg");
        } catch (HttpExceptionHandler httpExceptionHandler) {
            httpExceptionHandler.printStackTrace();
        }


    }
}
