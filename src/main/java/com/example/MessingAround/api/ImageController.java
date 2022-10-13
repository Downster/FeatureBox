package com.example.MessingAround.api;

import com.example.MessingAround.model.Image;
import com.example.MessingAround.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@AllArgsConstructor
@ResponseBody
@CrossOrigin("*")
public class ImageController {
    ImageService service;

    @GetMapping
    public ResponseEntity<List<Image>> getImages() {
        return new ResponseEntity<>(service.getAllImages(), HttpStatus.OK);
    }

    @PostMapping(
            path = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Image> saveImage(@RequestParam("name") String name,
                                         @RequestParam("description") String description,
                                         @RequestParam("owner") String owner,
                                         @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(service.saveEncodedImage(name, description, owner, file), HttpStatus.OK);
    }

}
