package com.edn.base;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;

import java.io.File;

public class Teste {

    public static void main(String[] args) {
        s3Publisher();
    }

    public static void s3Publisher() {
        String pathname = "/home/edney/teste.txt";
        String accessKey = "AKIAXD37XJHIWJOQFEHY";
        String secretKey = "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";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonS3 s3Client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

//        seq-telerisco-ultimoIdPedido-data.txt

        s3Client.putObject("arquivos-telerisco", "0-telerisco-0-29102020.txt", new File(pathname));
    }

    public static void printS3FilesFromBucket() {
        String bucketName  = "arquivos-telerisco";
        String accessKey = "AKIAXD37XJHIWJOQFEHY";
        String secretKey = "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";
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        AmazonS3 s3Client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();

        ObjectListing ol = s3Client.listObjects(bucketName);
        ol.getObjectSummaries().forEach(os -> System.out.println(os.getKey()));
    }

}
