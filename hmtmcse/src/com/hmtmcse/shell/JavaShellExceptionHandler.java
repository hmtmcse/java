package com.hmtmcse.shell;

/**
 * Created by touhid on 13/12/2015.
 */
public class JavaShellExceptionHandler extends Exception {

    public JavaShellExceptionHandler(){
        super("Unknown Exception");
    }

    public JavaShellExceptionHandler(String message){
        super(message);
    }

}
