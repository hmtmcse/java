package com.hmtmcse.advanced.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by touhid on 27/12/2015.
 */
public class FileDirectoryOperation {

    public boolean export(String content, String name, String location){
        File file = new File(location);
        if (!file.exists()){
            file.mkdirs();
        }
        String saveTo = location + File.separator + name;
        return writeToFile(content,saveTo);
    }

    public boolean writeToFile(String content, String locationName){
        try {
            FileWriter file = new FileWriter(locationName);
            file.write(content);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
