package com.kata.clientprofilefacade.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class ValidateToken {

    private final RestTemplate restTemplate;

    public  HttpStatus checkToken(String token) {
        ResponseEntity<String> response = sendToken(token);
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return HttpStatus.OK;
        } else if (statusCode == HttpStatus.NOT_FOUND) {
            return HttpStatus.NOT_FOUND;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }


    public ResponseEntity<String> sendToken(String token) {


        String[] splitToken = token.split(" ");

        String url = "http://127.0.0.1:1111/documents/checktoken?token=" + splitToken[1]; // Замените на фактический URL другого микросервиса

        ResponseEntity<String> response;
        try {
            HttpEntity<String> entity = new HttpEntity<>(splitToken[1]);
            response = restTemplate.postForEntity(url, entity, String.class);

        } catch (HttpClientErrorException e) {
            response = new ResponseEntity<>(e.getStatusCode());
        }
        return response;
    }
}
