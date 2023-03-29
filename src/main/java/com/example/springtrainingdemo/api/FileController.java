package com.example.springtrainingdemo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/file-handle")
public class FileController {

    @PostMapping
    public ResponseEntity<String>  handleUpload(@RequestParam("file") MultipartFile file){
        return null;
    }
}
