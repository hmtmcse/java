package com.hmtmcse.bismillah;

public class CustomException extends Exception {

    public CustomException(){
        super("Unknown Exception");
    }

    public CustomException(String message){
        super(message);
    }

}
