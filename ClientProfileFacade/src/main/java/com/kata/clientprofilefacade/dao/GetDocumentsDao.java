package com.kata.clientprofilefacade.dao;

import org.kata.dto.response.DocumentsResponseDto;
import org.springframework.http.ResponseEntity;

public interface GetDocumentsDao {
    <T> ResponseEntity<T> giveDocuments(String token, String uuid);
}
