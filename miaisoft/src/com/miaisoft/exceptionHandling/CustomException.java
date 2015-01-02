package com.miaisoft.exceptionHandling;

/**
 * Created by Touhid Mia on 11/09/2014.
 */
public class CustomException extends Exception {

    public  CustomException(){
        super("Custom Exception occurred");
    }

    public CustomException(String message){
       super(message);
    }


}
