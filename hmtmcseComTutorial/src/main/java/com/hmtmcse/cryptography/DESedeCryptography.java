package com.hmtmcse.cryptography;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class DESedeCryptography {

    private static final String DES_EDE = "DESede";
    private static final String KEY_24_CHARACTER = "123456789ABCDABCDSYAZXQWR";


    public static void main(String[] args) {
        try {
            String text = "www.hmtmcse.com";
            String encryptedText = encrypt(text);
            String decryptedText = decrypt(encryptedText);

            System.out.println("Encrypted: " + encryptedText);
            System.out.println("Decrypted: " + decryptedText);

        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }


    public static String encrypt(String text) throws Throwable{
        Cipher cipher = Cipher.getInstance(DES_EDE);
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
        byte[] inputBytes = text.getBytes();
        byte[] cipherText = cipher.doFinal(inputBytes);
        return Base64.encode(cipherText);
    }


    public static String decrypt(String encryptedText) throws Throwable{
        byte[] cipherText = Base64.decode(encryptedText);
        Cipher cipher = Cipher.getInstance(DES_EDE);
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey());
        byte[] decrypt = cipher.doFinal(cipherText);
        return new String(decrypt);
    }


    public static SecretKey getSecretKey() throws Throwable {
        byte[] keyBytes = KEY_24_CHARACTER.getBytes("ASCII");
        DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(DES_EDE);
        return factory.generateSecret(keySpec);
    }

}
