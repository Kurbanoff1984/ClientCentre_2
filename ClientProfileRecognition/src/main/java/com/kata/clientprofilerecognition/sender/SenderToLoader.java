package com.kata.clientprofilerecognition.sender;

import com.kata.clientprofilerecognition.recognitionDTO.RecognitionDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SenderToLoader {
    private final String url = "http://localhost:8080/api/endpoint";
    private final Logger logger = LogManager.getLogger(SenderToLoader.class);

    public void SendToLoader() {
        RestTemplate restTemplate = new RestTemplate();
        RecognitionDTO recognitionDTO = new RecognitionDTO();
        recognitionDTO.getRecognizedDocument();
        recognitionDTO.getIcp();
        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(recognitionDTO), Void.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            logger.info("Request was successful");
        } else {
            logger.error("Request failed");
        }
    }

}
