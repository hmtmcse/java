package com.hmtmcse.aws.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Grant;
import com.hmtmcse.aws.AwsConstant;

import java.util.List;

public class ACLManager {

    public void changeACL(){

    }


    public static void printAllPermission(String objectName) {
        final AmazonS3 s3 = CredentialManager.getS3Client();
        try {
            AccessControlList acl = s3.getObjectAcl(AwsConstant.BUCKET_NAME, objectName);
            List<Grant> grants = acl.getGrantsAsList();
            for (Grant grant : grants) {
                System.out.format("  %s: %s\n", grant.getGrantee().getIdentifier(), grant.getPermission().toString());
            }
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

}
