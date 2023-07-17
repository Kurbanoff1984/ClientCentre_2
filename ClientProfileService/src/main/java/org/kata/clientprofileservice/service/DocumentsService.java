package org.kata.clientprofileservice.service;

import org.kata.dto.response.DocumentsResponseDto;



public interface DocumentsService {
    DocumentsResponseDto getDocuments(String icp);
}
