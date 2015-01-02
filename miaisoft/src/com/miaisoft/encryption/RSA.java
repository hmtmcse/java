package com.miaisoft.encryption;

/**
 * Created by Touhid Mia on 25/10/2014.
 */

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;


public class RSA {

    public static void main(String[] args) throws Exception {

        String userPass = "rfq4s12as-0929218491834094";
        String encoded = Base64.encode(userPass.getBytes());
        System.out.println(encoded);

        userPass = "rfq4s12as-092921878834094";
        encoded = Base64.encode(userPass.getBytes());
        System.out.println(encoded);
    }

}
