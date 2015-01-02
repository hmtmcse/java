package com.miaisoft.miscellaneous;

import java.io.UnsupportedEncodingException;

/**
 * Created by Touhid Mia on 13/09/2014.
 */
public class StringOperation {

    public static void main(String[] args) {
        stringToByteSize("This is Touhid Mia");
    }




    public static void stringToByteSize(String string){
        try {
            System.out.println(string.getBytes("utf8").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
