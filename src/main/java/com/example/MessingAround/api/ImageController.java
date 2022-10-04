package com.example.MessingAround.api;

import com.example.MessingAround.model.Image;
import com.example.MessingAround.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

    ImageService service;

    @GetMapping
    public ResponseEntity<List<Image>> getImages() {
        return new ResponseEntity<>(service.getAllTodos(), HttpStatus.OK);
    }

}
