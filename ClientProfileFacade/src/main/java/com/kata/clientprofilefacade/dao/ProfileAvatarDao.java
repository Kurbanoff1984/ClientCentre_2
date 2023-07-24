package com.kata.clientprofilefacade.dao;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfileAvatarDao {
    <T>ResponseEntity<T> performAvatarOperation(MultipartFile file, Integer id, String profileIdentification, String uuid, Boolean active, String endpoint, HttpMethod httpMethod, Class<T> responseType, HttpServletRequest request, String graphName) throws IOException;
}
