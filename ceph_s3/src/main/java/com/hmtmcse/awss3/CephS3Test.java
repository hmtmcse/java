package com.hmtmcse.awss3;

import java.io.File;

/**
 * Created by touhid on 2/01/2017.
 */
public class CephS3Test {

    public static void main(String[] args) {
        CephS3 cephS3 = new CephS3();
        ResponseData responseData = cephS3.uploadRestrictFile(new File("C:\\Users\\touhid\\Desktop\\temp\\logo.jpg"),"images/screen/logo.jpg");
        if (responseData.isSuccess){
            System.out.println("Success");
        }else {
            System.out.println("Error: " + responseData.getMessage());
        }

        System.out.println(cephS3.deleteObject("images/screen/logo.jpg"));
//        System.out.println(cephS3.getPublicFileURL("images/screen/logo.jpg"));
        System.out.println("isExists = "  + cephS3.isObjectExists("images/screen/logo.jpg"));
    }

}
