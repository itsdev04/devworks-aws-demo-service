// package com.devworks.listener;
//
// import io.awspring.cloud.sqs.annotation.SqsListener;
// import org.springframework.stereotype.Component;
//
// @Component
// public class QueueListener {
//
//  // Spring Boot automatically listens to this queue asynchronously
//  @SqsListener("imkrdev-sqs-queue")
//  public void listenToMessages(String message) {
//    System.out.println("|| SQS MESSAGE RECEIVED ||");
//    System.out.println("Processing file event data: " + message);
//  }
// }
