package com.kata.clientprofilefacade.service.impl;

import lombok.AllArgsConstructor;
import org.kata.dto.response.DocumentsResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class UserCheck {

    private final RestTemplate restTemplate;

    public ResponseEntity<?> getDocumentsById(String uuid) {
        String loaderUrl = "http://127.0.0.1:1111/documents/" + uuid; // url к loader

        ResponseEntity<DocumentsResponseDto> documentsResponse;

        documentsResponse = restTemplate.getForEntity(loaderUrl, DocumentsResponseDto.class);


        if (documentsResponse.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(documentsResponse.getBody());
        } else {
            return new ResponseEntity<>("Ошибка получения DocumentsResponseDto", documentsResponse.getStatusCode());
        }
    }
}
