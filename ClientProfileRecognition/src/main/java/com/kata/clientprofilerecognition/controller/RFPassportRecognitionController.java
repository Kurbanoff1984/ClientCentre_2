package com.kata.clientprofilerecognition.controller;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import com.kata.clientprofilerecognition.service.RFPassportRecognitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class RFPassportRecognitionController {
    private final RFPassportRecognitionService rFPassportRecognitionService;

    public RFPassportRecognitionController(RFPassportRecognitionService rFPassportRecognitionService) {
        this.rFPassportRecognitionService = rFPassportRecognitionService;
    }
    @PostMapping("/ocrRFPassportDoc")
    public ResponseEntity<RFPassportDocRecognitionDto> recognizeRFPassportDoc(@RequestParam("file") MultipartFile file) throws IOException {
        rFPassportRecognitionService.recognizeRFPassport(file.getInputStream());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
