package com.hmtmcse.advanced.cryptography.basic;


import com.google.common.io.BaseEncoding;

import java.io.UnsupportedEncodingException;

/**
 * Created by touhid on 7/06/2016.
 */
public class BasicBase64 {

    public static void main(String[] args) {

        try {
            String inputContent = "Hello World";
            String base64String = BaseEncoding.base64().encode(inputContent.getBytes("UTF-8"));

            System.out.println("Base64:" + base64String);
            byte[] contentInBytes = BaseEncoding.base64().decode(base64String);
            System.out.println("Source content: " + new String(contentInBytes, "UTF-8"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
