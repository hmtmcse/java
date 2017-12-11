package com.hmtmcse.advanced.fileio;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by touhid on 7/11/2016.
 */
public class FileListForJSTree {

    public static String concatLocation(String first, String second){
        if (first.endsWith("/") || first.endsWith("\\")){
            return first + second;
        }else {
            return first + File.separator + second;
        }
    }

    private static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        }else{
            return "";
        }
    }




    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\touhid\\Desktop\\gitosis-admin";

        File root = new File( path );
        File[] list = root.listFiles();
        FileInfoData fileInfoData;

        String pathX = concatLocation(path,"");

        List<FileInfoData> fileInfoList = new ArrayList<FileInfoData>();
        String relativePath, cssClass;
        for (File file : list ) {
            relativePath = file.getPath().replace(pathX,"");
            if (file.isDirectory() ) {
                fileInfoList.add(new FileInfoData(file.getName(), relativePath, "folder", true ));
            }else {
                fileInfoData = new FileInfoData(file.getName(), relativePath, "file", false );
                cssClass = "file ";
                if (!getFileExtension(file.getName()).equals("")){
                    cssClass += getFileExtension(file.getName());
                }
                fileInfoData.setType(cssClass);
                fileInfoList.add(fileInfoData);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fileInfoList));

    }

}
