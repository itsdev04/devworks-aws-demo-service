package com.devworks.service;

import io.awspring.cloud.s3.S3Template;
import io.awspring.cloud.sns.core.SnsTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageService {

    private final S3Template s3Template;
    private final SnsTemplate snsTemplate;

    @Value("${aws.bucket-name}")
    private String bucketName;

    @Value("${aws.sns-topic-arn}")
    private String topicArn;

    public StorageService(S3Template s3Template, SnsTemplate snsTemplate){
        this.s3Template = s3Template;
        this.snsTemplate = snsTemplate;
    }

    public String uploadFileAndNotify(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        // 1. Upload file to Amazon S3
        s3Template.upload(bucketName, fileName, file.getInputStream());

        // 2. Publish alert to Amazon SNS
        String alertMessage = "File uploaded successfully: " + fileName;
        snsTemplate.convertAndSend(topicArn, alertMessage);

        return fileName;
    }

}
