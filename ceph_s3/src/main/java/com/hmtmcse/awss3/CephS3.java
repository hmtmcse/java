package com.hmtmcse.awss3;

/**
 * Created by touhid on 26/12/2016.
 */

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.File;


public class CephS3 {

    String ACCESS_KEY = "V74OWEBA8I72UZQP4M0N";
    String SECRET_KEY = "dwMQJmSRs4Mk7PrvlIdlUeO0XfROKllZ2qaMIDhz";
    String SERVER_WITH_PORT = "xxxxx";
    String STORAGE_POOL_NAME = "touhid-mia";

    private AmazonS3 storageServer;
    private Bucket storagePool;

    public CephS3() {
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        storageServer = new AmazonS3Client(credentials);
        storageServer.setEndpoint(SERVER_WITH_PORT);
        storagePool = storageServer.createBucket(STORAGE_POOL_NAME);
    }


    private ResponseData uploadFile(File file, String nameHash, Boolean isPublic){
        ResponseData responseData = new ResponseData(false);

        if (!file.exists()){
            responseData.setMessage("File Not Exists.");
            return responseData;
        }

        PutObjectRequest putObjectRequest = new PutObjectRequest(STORAGE_POOL_NAME, nameHash, file);
        if (isPublic){
            putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
        }
        try {
            storageServer.putObject(putObjectRequest);
            responseData.setSuccess(true);
        } catch (AmazonServiceException ase) {
            responseData.setMessage(ase.getMessage());
            responseData.setStatusCode(ase.getStatusCode());
            responseData.setErrorCode(ase.getErrorCode());
        }catch (AmazonClientException ace) {
            responseData.setMessage(ace.getMessage());
        }
       return responseData;
    }

    public ResponseData uploadPublicFile(File file, String nameHash){
        return uploadFile(file,nameHash,true);
    }

    public ResponseData uploadRestrictFile(File file, String nameHash){
        return uploadFile(file,nameHash,false);
    }


    public String getRestrictFileURL(String nameHash){
        if (!isObjectExists(nameHash)){
            return null;
        }
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(STORAGE_POOL_NAME, nameHash);
        try {
           return storageServer.generatePresignedUrl(request).toString();
        }catch (AmazonClientException ace) {
            return null;
        }
    }

    public String getPublicFileURL(String nameHash){
        if (!isObjectExists(nameHash)){
            return null;
        }
        String url = concatURL(SERVER_WITH_PORT,STORAGE_POOL_NAME);
        return concatURL(url,nameHash);
    }


    public Boolean isObjectExists(String nameHash){
        try {
            storageServer.getObjectMetadata(STORAGE_POOL_NAME, nameHash);
        } catch(AmazonServiceException e) {
            return false;
        }
        return true;
    }

    public Boolean deleteObject(String nameHash){
        if (!isObjectExists(nameHash)){
            return false;
        }
        try {
            storageServer.deleteObject(new DeleteObjectRequest(STORAGE_POOL_NAME, nameHash));
        }catch (AmazonServiceException ase){
            return false;
        } catch(AmazonClientException e) {
            return false;
        }
        return true;
    }



    public String concatURL(String first, String second){
        if (first.endsWith("/")){
            return first + second;
        }else {
            return first + "/" + second;
        }
    }




}
