package com.hmtmcse.elasticsearch;

import com.hmtmcse.elasticsearch.http.HttpExceptionHandler;
import com.hmtmcse.elasticsearch.http.HttpRequester;
import com.hmtmcse.elasticsearch.http.HttpResponseData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by touhid on 7/09/2016.
 */
public class Search {

    public static void main(String[] args) {
        HttpRequester httpRequester = new HttpRequester();
        httpRequester.READ_TIME = 1800000;
        HttpResponseData httpResponseData;

        try {
//            httpResponseData = httpRequester.HEAD("http://localhost:9200/sqa7_webcommander_biz/_search?q=" + URLEncoder.encode("July 2014", "UTF-8"));
            httpResponseData = httpRequester.HEAD("http://localhost:9200/sqa7_webcommander_biz");
            String response = httpResponseData.getContent();

            JSONParser jsonP = new JSONParser();
            JSONObject jo = (JSONObject) jsonP.parse(response);
            JSONArray ja = (JSONArray) jo.get("hits");

            System.out.println("httpResponseData " + response);


        } catch (HttpExceptionHandler httpExceptionHandler) {
            httpExceptionHandler.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
