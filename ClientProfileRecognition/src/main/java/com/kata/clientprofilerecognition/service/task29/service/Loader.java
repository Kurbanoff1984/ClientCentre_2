package com.kata.clientprofilerecognition.service.task29.service;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
@Slf4j
public class Loader {
    private final RestTemplate restTemplate;
    String updateUrl = "http://localhost:8081/updateDocInfo/{icp}";
    public void addClientDocument (RFPassportDocRecognitionDto rfPassportDocRecognitionDto){
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RFPassportDocRecognitionDto> entity = new HttpEntity<>(rfPassportDocRecognitionDto,headers);
        ResponseEntity<String> response = restTemplate.exchange(updateUrl, HttpMethod.PUT,entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Client information updated:"  + rfPassportDocRecognitionDto);
        } else {
            log.error("Failed to update client information");
        }
    }
}
