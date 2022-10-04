package com.example.MessingAround.config;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {
    ENCODED_IMAGE("spring-app-storage");
    private final String bucketName;
}