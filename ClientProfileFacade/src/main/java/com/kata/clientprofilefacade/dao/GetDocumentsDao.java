package com.kata.clientprofilefacade.dao;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface GetDocumentsDao {
    <T> ResponseEntity<T> giveDocuments(String token, String uuid, HttpServletRequest request, String graphName);
}
