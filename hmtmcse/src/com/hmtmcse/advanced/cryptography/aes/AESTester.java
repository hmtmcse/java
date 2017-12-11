package com.hmtmcse.advanced.cryptography.aes;

import java.io.File;

/**
 * Created by touhid on 16/04/2015.
 */
public class AESTester {

    public static void main(String[] args) {
        String key = "ABCDEFGHABCDEFGH";
        File inputFile = new File("D:\\cipherTest\\document.txt");
        File encryptedFile = new File("D:\\cipherTest\\document.encrypted");
        File decryptedFile = new File("D:\\cipherTest\\document.decrypted");

        try {
            AESCipher.encrypt(key, inputFile, encryptedFile);
            AESCipher.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
