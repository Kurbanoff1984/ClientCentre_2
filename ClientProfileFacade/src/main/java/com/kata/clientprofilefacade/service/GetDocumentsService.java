package com.kata.clientprofilefacade.service;

import org.springframework.http.ResponseEntity;

public interface GetDocumentsService {
    <T> ResponseEntity<T> giveDocuments(String token, String uuid);
}
