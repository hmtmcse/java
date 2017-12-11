package com.hmtmcse.advanced.fileio.fd;

import java.io.File;
import java.util.ArrayList;

public class FDListing {




    public FDResponseData listDirectory(String path){

        FDResponseData fdResponseData = new FDResponseData();
        fdResponseData.setSuccess(false);

        File pathFile = new File(path);
        if (!pathFile.exists()){
            fdResponseData.setMessage("Invalid Location. : " + pathFile.getAbsolutePath());
            return fdResponseData;
        }

        File[] pathFileList = pathFile.listFiles();
        if (pathFileList == null){
            fdResponseData.setSuccess(true);
            fdResponseData.setMessage("Empty Directory");
            return fdResponseData;
        }

        DirectoryInfoData directoryInfoData;
        FDResponseData subDirectoryResponse;
        for (File directoryList : pathFileList){
            directoryInfoData = new DirectoryInfoData();
            directoryInfoData.setName(directoryList.getName());
            directoryInfoData.setLastModified(directoryList.lastModified());
            directoryInfoData.setAbsolutePath(directoryList.getAbsolutePath());
            if (directoryList.isDirectory()){
                directoryInfoData.isDirectory = true;
                subDirectoryResponse = listDirectory(directoryList.getAbsolutePath());
                if (subDirectoryResponse.getSuccess() && subDirectoryResponse.getDirectoryInfoDataList() != null){
                    directoryInfoData.setSubDirectory(subDirectoryResponse.getDirectoryInfoDataList());
                }else{
                    directoryInfoData.setSubDirectory(new ArrayList<>());
                }
            }
            fdResponseData.addDirectoryInfo(directoryInfoData);
        }
        fdResponseData.setSuccess(true);
        return fdResponseData;
    }

    public static void main(String[] args) {
        FDListing fdListing = new FDListing();
        FDResponseData fdResponseData = fdListing.listDirectory("F:\\codes\\webcommander\\webcommander\\docs\\wc-kb");

        System.out.println("Echo");
    }



}
