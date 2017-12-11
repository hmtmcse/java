package com.hmtmcse.awss3;

/**
 * Created by touhid on 2/01/2017.
 */
public class ResponseData {

    public Boolean isSuccess;
    String message = null;
    Integer statusCode = null;
    String ErrorCode = null;


    public ResponseData(Boolean isSuccess){
        this.isSuccess = isSuccess;
    }

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


    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
