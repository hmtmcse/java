package com.hmtmcse.elasticsearch.esorm;


import com.hmtmcse.elasticsearch.http.HttpExceptionHandler;
import com.hmtmcse.elasticsearch.http.HttpRequester;
import com.hmtmcse.elasticsearch.http.HttpResponseData;

/**
 * Created by touhid on 19/09/2016.
 */
public class ESManager {

    private HttpRequester httpRequester;
    public String SERVER_URL = "http://localhost:9200";
    public String INDEX_NAME = "";

    public ESManager() throws AppExceptionHandler {
        httpRequester = new HttpRequester();
        httpRequester.READ_TIME = 1800000;
        if (!isAliveES()){
            throw new AppExceptionHandler("Unable To Connect ElasticSearch Server");
        }
    }


    public boolean isAliveES(){
        try {
            HttpResponseData httpResponseData = httpRequester.GET(getURL(""));
            if (httpResponseData.getResponse() == 200){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }


    public boolean isExistIndex(String indexName){
        try {
            HttpResponseData httpResponseData = httpRequester.HEAD(getURL(indexName));
            if (httpResponseData.getResponse() == 200){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }

    public boolean isExistType(String indexName, String type){
        try {
            HttpResponseData httpResponseData = httpRequester.HEAD(getURL(indexName + "/" + type));
            if (httpResponseData.getResponse() == 200){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }

    public boolean createIndex(String indexName, String settingJSON){
        try {
            HttpResponseData httpResponseData = httpRequester.PUT(getURL(indexName),settingJSON);
            if (httpResponseData.getResponse() == 200){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }


    public boolean createMapping(String indexName, String mappingName, String propertiesJSON){
        try {
            HttpResponseData httpResponseData = httpRequester.PUT(getURL(indexName + "/_mapping/" + mappingName),propertiesJSON);
            if (httpResponseData.getResponse() == 200){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }


    public String list(String typeName, String filter){
        try {
            String url = getURL(INDEX_NAME) + "/" + typeName + "/_search";
            if (filter != null){
                url += "?" + filter;
            }
            HttpResponseData httpResponseData = httpRequester.GET(url);
            if (httpResponseData.getResponse() == 200){
                return httpResponseData.getContent();
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return null;
        }
        return null;
    }

    public boolean update(String typeName, String id, String jsonData){
        try {
            HttpResponseData httpResponseData = httpRequester.PUT(getURL(INDEX_NAME + "/" + typeName + "/" + id),jsonData);
            if (httpResponseData.getResponse() == 200){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }

    public boolean insert(String typeName, String jsonData){
        try {
            HttpResponseData httpResponseData = httpRequester.POST(getURL(INDEX_NAME + "/" + typeName + "/?_create"),jsonData);
            if (httpResponseData.getResponse() == 201){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }

    public boolean delete(String typeName, String id){
        try {
            HttpResponseData httpResponseData = httpRequester.DELETE(getURL(INDEX_NAME + "/" + typeName + "/" + id));
            if (httpResponseData.getResponse() == 200){
                return true;
            }
        } catch (HttpExceptionHandler httpExceptionHandler) {
            Log.error(httpExceptionHandler.getMessage());
            return false;
        }
        return false;
    }


    private String getURL(String postfix){
       return SERVER_URL + "/" + postfix;
    }

}
