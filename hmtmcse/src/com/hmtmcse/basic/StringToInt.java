package com.hmtmcse.basic;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.nio.charset.Charset;

/**
 * Created by Tou on 6/03/2015.
 */
public class StringToInt {

    public static void main(String[] args) {
        String encodedBytes = Base64.encode("http://stackoverflow.com/questions/19743851/base64-java-encode-and-decode-a-string".getBytes()).replace("\n","_");
        System.out.println(encodedBytes.replace("\n","_"));
    }
}
