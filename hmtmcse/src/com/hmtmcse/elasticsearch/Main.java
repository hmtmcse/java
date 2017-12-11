package com.hmtmcse.elasticsearch;


import com.hmtmcse.elasticsearch.esdata.Result;
import com.hmtmcse.elasticsearch.esorm.AppExceptionHandler;
import com.hmtmcse.elasticsearch.esorm.ESManager;
import com.hmtmcse.elasticsearch.esorm.Log;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by touhid on 4/09/2016.
 */
public class Main {


    public static void main(String[] args) {

        try {
            ESManager esManager = new ESManager();
            esManager.INDEX_NAME = "touhid";

            String json = esManager.list("info",null);


            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Result result = mapper.readValue(json,Result.class);

            Log.info(json);



        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AppExceptionHandler appExceptionHandler) {
            appExceptionHandler.printStackTrace();
        }
    }


}
