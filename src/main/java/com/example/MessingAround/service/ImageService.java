package com.example.MessingAround.service;

import com.example.MessingAround.config.BucketName;
import com.example.MessingAround.model.Image;

import com.example.MessingAround.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@AllArgsConstructor
@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final FileStore fileStore;

    public List<Image> getAllImages(){
        List<Image> images = new ArrayList<Image>();
        imageRepository.findAll().forEach(images::add);
        return images;
    }

    public Image saveEncodedImage(String name, String description, String owner, MultipartFile file){

        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }

        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File is not an image");
        }

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s/%s", BucketName.ENCODED_IMAGE.getBucketName(), UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());

        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }

        Image image = Image.builder()
                .name(name)
                .description(description)
                .owner(owner)
                .url(path)
                .build();
        image = imageRepository.save(image);
        return image;
    }
}
