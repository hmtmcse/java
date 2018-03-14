package com.hmtmcse.aws.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.AmazonServiceException;

import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.hmtmcse.aws.AwsConstant;

import java.io.File;

public class Upload {




    private AmazonS3 getS3Client() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(AwsConstant.ACCESS_KEY, AwsConstant.SECRET_KEY);
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).withRegion(AwsConstant.REGION).build();
    }

    public void print(){
        System.out.println("test");
    }


    public void uploadDirectory(String source, String destination) {
        TransferManager transferManager = TransferManagerBuilder.standard().withS3Client(getS3Client()).build();
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

    public static void main(String[] args) {
        Upload upload = new Upload();
        upload.uploadDirectory("C:\\Users\\touhid\\Desktop\\image", "tanvirul");
    }

}

