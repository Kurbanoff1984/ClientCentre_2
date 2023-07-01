package com.kata.clientprofilefacade.dao;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileAvatarDao {
    <T>ResponseEntity<T> performAvatarOperation(MultipartFile file, Integer id, String profileIdentification, String uuid, boolean active, String endpoint, HttpMethod httpMethod, Class<T> responseType);
}
