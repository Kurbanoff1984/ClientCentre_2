package com.kata.clientprofilerecognition.controller;

import com.kata.clientprofilerecognition.service.RFDrivingLicenseRecognitionService;
import com.kata.clientprofilerecognition.service.RFPassportRecognitionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Этот контроллер получает 2 параметра: строку с названием распознаваемого документа
 * и файл с изображением документа, вызывает необходимый метод сервиса и возвращает DTO с распознанными полями
 * либо bad request
 */

@AllArgsConstructor
@RestController
public class DocumentRecognitionController {
    private final RFPassportRecognitionService rfPassportRecognitionService;
    private final RFDrivingLicenseRecognitionService rfDrivingLicenseRecognitionService;

    /**
     * Этот метод получает 2 параметра и в зависимости от параметра recognizableDocument вызывает метод
     * необходимого сервиса
     */

    @PostMapping("/recognizeDocument")
    public <T> ResponseEntity<T> recognizeDocument(@RequestParam String recognizableDocument,
                                                   @RequestParam("file") MultipartFile file) throws IOException {
        switch (recognizableDocument) {
            case ("RFPassport") -> {
                return rfPassportRecognitionService.recognizeRFPassport(file.getInputStream());
            }
            case ("RFDrivingLicense") -> {
                return rfDrivingLicenseRecognitionService.recognizeRFDrivingLicense(file.getInputStream());
            }
        }
        return ResponseEntity.badRequest().build();
    }
}