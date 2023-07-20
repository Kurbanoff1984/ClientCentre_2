package com.kata.clientprofilerecognition.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;

public interface RFDrivingLicenseRecognitionService {
    <T> ResponseEntity<T> recognizeRFDrivingLicense(InputStream inputStream) throws IOException;
}
