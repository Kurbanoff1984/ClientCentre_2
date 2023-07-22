package com.kata.clientprofilefacade.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface GetDocumentsService {
    <T> ResponseEntity<T> giveDocuments(String token, String uuid, HttpServletRequest request, String graphName);
}
