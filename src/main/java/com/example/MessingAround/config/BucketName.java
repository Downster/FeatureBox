package com.example.MessingAround.config;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BucketName {
    ENCODED_IMAGE("spring-amazon-storage");
    private final String bucketName;
}