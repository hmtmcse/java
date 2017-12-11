package com.miaisoft.conversion;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Created by touhid on 2/11/2014.
 */
public class ToFromHex {

    public static void main(String[] args) {



        System.out.println("bmpjM2B3anksYzFkMTc0NDIsZTFiNCwzMzYwLDdjMWQsZTdkYGEvN2Bg".length());


//        String uuid = java.util.UUID.randomUUID().toString();
//        System.out.println("012dju1sr-" + uuid);
//        String encoded = Base64.encode("This is Touhid Mia".getBytes());
//        System.out.println(encoded);
    }

    public static void getHexFromString(String value){
        String code = "";
        for (int i = 0; i < value.length(); i++){
            if (i != 0 ){
                code += "-" + (int) value.charAt(i);
            } else{
                code += (int) value.charAt(i);
            }
        }
        System.out.print(code);
    }

}
