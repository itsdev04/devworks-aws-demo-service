package com.devworks.controller;

import com.devworks.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/aws")
public class AwsDemoController {
  private final StorageService storageService;

  public AwsDemoController(StorageService storageService) {
    this.storageService = storageService;
  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) {
    try {
      String fileName = storageService.uploadFileAndNotify(file);
      return "Success! File " + fileName + " is now in S3, and notification was broadcast.";
    } catch (Exception e) {
      return "Failed to process: " + e.getMessage();
    }
  }
}
