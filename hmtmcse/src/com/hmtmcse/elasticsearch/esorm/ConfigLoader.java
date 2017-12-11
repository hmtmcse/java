package com.hmtmcse.elasticsearch.esorm;

import java.io.*;
import java.util.Properties;

/**
 * Created by touhid on 27/12/2015.
 */
public class ConfigLoader {

    public static String configProperties = "es.properties";


    public static String getPropertiesById(String name){
        Properties properties = new Properties();
        File file = new File(configProperties);
        if (!file.exists()){
            return null;
        }else{
            try {
                InputStream inputStream = new FileInputStream(file);
                properties.load(inputStream);
                inputStream.close();
                return properties.getProperty(name,null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getESServerURLURL(){
        String url =  getPropertiesById("es.server.url");
        if (url != null){
            return url;
        }else{
            return null;
        }
    }

    public static String getWCJSONLocation(){
        String url =  getPropertiesById("wc.jsons");
        if (url != null){
            return url;
        }else{
            return null;
        }
    }



}
