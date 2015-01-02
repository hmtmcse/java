package com.miaisoft.conversion;

/**
 * Created by touhid on 3/11/2014.
 */
import com.sun.org.apache.xml.internal.security.utils.Base64;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class CipherExample {

    public static String KEY = "9ed5D73x";

    public static void main(String[] args) {

        try {
            encrypt("012dju1sr-eff64550-7ec0-4e82-a583-baaa9ed53738");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        try {
            String key = "9ed5D73x"; // needs to be at least 8 characters for DES

            FileInputStream fis = new FileInputStream("C:\\Users\\touhid\\Desktop\\DES\\original.txt");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\touhid\\Desktop\\DES\\encrypted.txt");
            encrypt(key, fis, fos);

            FileInputStream fis2 = new FileInputStream("C:\\Users\\touhid\\Desktop\\DES\\encrypted.txt");
            FileOutputStream fos2 = new FileOutputStream("C:\\Users\\touhid\\Desktop\\DES\\decrypted.txt");
            decrypt(key, fis2, fos2);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
    }

    public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
    }

    public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher);

            doCopy(cis, os);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, cos);
        }
    }


    public static void  encrypt(String plainText)throws Throwable {
        DESKeySpec dks = new DESKeySpec(KEY.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] respons = cipher.doFinal(plainText.getBytes());
        System.out.println(Base64.encode(respons) + "  " + respons);

    }

    public static void doCopy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[64];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }

}
