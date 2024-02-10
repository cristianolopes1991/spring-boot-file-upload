package com.poc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value ="/api/upload", produces = {"application/json"})
@CrossOrigin("*")
public class UploadArquivoController {

    @PostMapping("/arquivo")
    public ResponseEntity<String> salvarArquivo(@RequestParam("file")MultipartFile file) {
        return null;
    }
}
