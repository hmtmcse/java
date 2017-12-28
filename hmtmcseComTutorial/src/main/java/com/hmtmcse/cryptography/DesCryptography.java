package com.hmtmcse.cryptography;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by touhid on 7/06/2016.
 */
public class DesCryptography {

    private static final String DES_EDE = "DESede";
    public static void main(String[] args) throws Exception {
        String name = encryptF("");
        System.out.println("Encrypt: " + name);
        System.out.println("Decrypted: " + decryptF(name));
    }

    public static String encryptF(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(DES_EDE);
        cipher.init(Cipher.ENCRYPT_MODE, generateKey());
        byte[] inputBytes = input.getBytes();
        byte[] cipherText = cipher.doFinal(inputBytes);
        return Base64.encode(cipherText);
    }

    public static String decryptF(String encryptionBytes) throws Base64DecodingException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        byte[] cipherText = Base64.decode(encryptionBytes);
        Cipher cipher = Cipher.getInstance(DES_EDE);
        cipher.init(Cipher.DECRYPT_MODE, generateKey());
        byte[] decrypt = cipher.doFinal(cipherText);
        String decrypted = new String(decrypt);
        return decrypted;
    }

    public static SecretKey generateKey() throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] keyBytes = "1234567890azertyuiopqsdf".getBytes("ASCII");
        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(DES_EDE);
        SecretKey key = factory.generateSecret(keySpec);
        return key;
    }


    public static String decrypt(String encryptionBytes){
        String decript = null;
        try {
            decript = decryptF(encryptionBytes);
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return decript;
    }

}
