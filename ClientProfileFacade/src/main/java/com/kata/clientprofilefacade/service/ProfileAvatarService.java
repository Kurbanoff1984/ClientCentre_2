package com.kata.clientprofilefacade.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileAvatarService {
    <T>ResponseEntity<T> performAvatarOperation(MultipartFile file, Integer id, String profileIdentification, String uuid, Boolean active, String endpoint, HttpMethod httpMethod, Class<T> responseType);

}
