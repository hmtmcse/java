package com.hmtmcse;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;

public class ListKeys {


    private static final String bucketName = "test";
    private static final String accessKey = "";
    private static final String secretKey = "";

    public static void main(String[] args) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.AP_SOUTHEAST_2)
                .build();


        try {
            System.out.println("Listing objects");
            final ListObjectsV2Request req = new ListObjectsV2Request()
                    .withBucketName(bucketName)
                    .withPrefix("product/")
                    .withDelimiter("/")
                    .withMaxKeys(2);
            ListObjectsV2Result result;
            do {
                result = s3client.listObjectsV2(req);
                System.out.println("getDelimiter() : " + result.getDelimiter());
                System.out.println("getPrefix : " + result.getPrefix());
//                System.out.println(" : " + result);
//                System.out.println(" : " + result);

                for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
                    System.out.println(" - " + objectSummary.getKey() + "  " + "(size = " + objectSummary.getSize() + ")");
                }

                result.getCommonPrefixes().forEach(p -> System.out.println("\t\t" + p));

//                System.out.println("Next Continuation Token : " + result.getNextContinuationToken());
                req.setContinuationToken(result.getNextContinuationToken());
            } while (result.isTruncated() == true);


            ListObjectsRequest request = new ListObjectsRequest().withBucketName(bucketName);
            ObjectListing objects = s3client.listObjects(request);
//            objects.getCommonPrefixes().forEach(p -> System.out.println("\t\t" + p));
//            objects.getObjectSummaries().forEach(p -> System.out.println("\t\t" + p));


//            System.out.println("Listing prefix '" + prefix + "'");
//            final ListObjectsV2Result result1 = s3client.listObjectsV2(new ListObjectsV2Request()
////                    .withPrefix("resources/product")
//                    .withDelimiter("/")
//                    .withBucketName(bucketName));
//
//            result1.setDelimiter("/");
//
//            System.out.println("\tCommon prefixes");
//            result1.getCommonPrefixes().forEach(p -> System.out.println("\t\t" + p));
//
//            System.out.println("\tKeys");
//            result1.getObjectSummaries().forEach(s -> System.out.println("\t\t" + s.getKey()));



        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, " +
                    "which means your request made it " +
                    "to Amazon S3, but was rejected with an error response " +
                    "for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, " +
                    "which means the client encountered " +
                    "an internal error while trying to communicate" +
                    " with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
    }


}