package com.hmtmcse.io.directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryList {

    public List<DirData> listDirectory(String location){
        List<DirData> dirDataList = new ArrayList<>();
        File locationFile = new File(location);
        DirData dirData;
        if (locationFile.exists()){
            for (File file : locationFile.listFiles() ) {
                dirData = DirData.instance()
                        .setName(file.getName())
                        .setLastModified(file.lastModified())
                        .setAbsolutePath(file.getAbsolutePath());
                if (file.isDirectory() ) {
                    dirData.setDirectory(true);
                    dirData.setSubDirectories(listDirectory(file.getAbsolutePath()));
                }
                dirDataList.add(dirData);
            }
        }
        return dirDataList;
    }


    public void printDirectory(List<DirData> list, String separator){
        for (DirData dirData : list){
            System.out.println(separator + " " + dirData.getName());
            if (dirData.getSubDirectories() != null && dirData.getSubDirectories().size() != 0){
                printDirectory(dirData.getSubDirectories(),separator + separator);
            }
        }
    }


    public static void main(String[] args) {
        DirectoryList directoryList = new DirectoryList();
        List<DirData> list = directoryList.listDirectory("W:\\opensource\\java\\hmtmcseComTutorial\\src\\main\\java\\com\\hmtmcse");
        directoryList.printDirectory(list, "-");

    }
}
