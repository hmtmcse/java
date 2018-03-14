package com.hmtmcse.aws.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.AmazonServiceException;

import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.hmtmcse.aws.AwsConstant;

import java.io.File;

public class UploadDownload {




    private AmazonS3 getS3Client() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(AwsConstant.ACCESS_KEY, AwsConstant.SECRET_KEY);
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).withRegion(AwsConstant.REGION).build();
    }



    public void uploadDirectory(String source, String destination) {
        AmazonS3 amazonS3 = getS3Client();

        TransferManager transferManager = TransferManagerBuilder.standard().withS3Client(amazonS3).build();
        try {
            MultipleFileUpload multipleFileUpload = transferManager.uploadDirectory(AwsConstant.BUCKET_NAME, destination, new File(source), true);
            multipleFileUpload.waitForCompletion();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        transferManager.shutdownNow();

        System.out.println("done");
    }

    public void changeACL(String destination){
        AmazonS3 amazonS3 = getS3Client();
        amazonS3.setObjectAcl(AwsConstant.BUCKET_NAME,destination, CannedAccessControlList.PublicRead);
    }


    public void downloadDirectory(String bucketSource, String destination){
        TransferManager transferManager = TransferManagerBuilder.standard().withS3Client(getS3Client()).build();
        try {
            MultipleFileDownload multipleFileDownload = transferManager.downloadDirectory(AwsConstant.BUCKET_NAME, bucketSource, new File(destination));
            multipleFileDownload.waitForCompletion();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transferManager.shutdownNow();
        System.out.println("done");
    }




    public static void main(String[] args) {
        UploadDownload upload = new UploadDownload();
        upload.uploadDirectory("C:\\Users\\touhid\\Desktop\\image", "public");
//        upload.changeACL("public");
//        upload.downloadDirectory("touhid","C:\\Users\\touhid\\Desktop\\awsTest");
//        upload.downloadDirectory(null,"C:\\Users\\touhid\\Desktop\\awsTest");
    }

}

