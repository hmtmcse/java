package com.hmtmcse.elasticsearch.esorm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by touhid on 20/09/2016.
 */
public class GeneralResponseData {

    Boolean isSuccess;
    String message;
    List<String> stringList = new ArrayList<String>();

    public GeneralResponseData(Boolean isSuccess, String message){
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public GeneralResponseData(){}


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

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void addItemInStringList(String string){
        if( stringList == null || stringList.size() == 0){
            stringList = new ArrayList<String>();
        }
        stringList.add(string);
    }
}
