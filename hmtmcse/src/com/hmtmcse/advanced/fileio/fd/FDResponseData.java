package com.hmtmcse.advanced.fileio.fd;

import java.util.ArrayList;
import java.util.List;

public class FDResponseData {

    public Boolean isSuccess;
    public String message;
    public List<DirectoryInfoData> directoryInfoDataList = new ArrayList<>();

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DirectoryInfoData> getDirectoryInfoDataList() {
        return directoryInfoDataList;
    }

    public void setDirectoryInfoDataList(List<DirectoryInfoData> directoryInfoDataList) {
        this.directoryInfoDataList = directoryInfoDataList;
    }

    public void addDirectoryInfo(DirectoryInfoData directoryInfoData){
        if (directoryInfoDataList == null){
            directoryInfoDataList = new ArrayList<>();
        }
        if (directoryInfoData != null){
            directoryInfoDataList.add(directoryInfoData);
        }
    }
}
