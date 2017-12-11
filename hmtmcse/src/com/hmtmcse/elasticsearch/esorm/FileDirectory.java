package com.hmtmcse.elasticsearch.esorm;

//import com.webmascot.data.GeneralResponseData;

import java.io.File;

/**
 * Created by touhid on 20/09/2016.
 */
public class FileDirectory {


    public static GeneralResponseData fileList(String location){
        GeneralResponseData generalResponseData = new GeneralResponseData(false,"File Not Found");
            File root = new File(location);
        if (!root.exists()) {
            return generalResponseData;
        }
        File[] list = root.listFiles();
        for (File file : list) {
            if (!file.isDirectory()) {
                generalResponseData.addItemInStringList(file.getName());
            }
        }
        generalResponseData.setSuccess(true);
        generalResponseData.setMessage("");
       return generalResponseData;
    }

    public static String concatLocation(String first, String second){
        if (first.endsWith("/") || first.endsWith("\\")){
            return first + second;
        }else {
            return first + File.separator + second;
        }
    }

}
