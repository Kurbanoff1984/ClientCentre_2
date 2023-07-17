package com.kata.clientprofilerecognition.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;

public interface RFPassportRecognitionService  {

    <T> ResponseEntity<T> recognizeRFPassport(InputStream inputStream) throws IOException;
}
