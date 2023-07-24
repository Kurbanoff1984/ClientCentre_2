package com.kata.clientprofilefacade.service.impl;

import com.kata.clientprofilefacade.dao.ProfileAvatarDao;
import com.kata.clientprofilefacade.service.ProfileAvatarService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ProfileAvatarServiceImpl implements ProfileAvatarService {

    private final ProfileAvatarDao profileAvatarDao;

    @Override
    public <T> ResponseEntity<T> performAvatarOperation(MultipartFile file, Integer id, String profileIdentification, String uuid, Boolean active, String endpoint, HttpMethod httpMethod, Class<T> responseType, HttpServletRequest request, String graphName) throws IOException {
        return profileAvatarDao.performAvatarOperation(file,id,profileIdentification,uuid,active,endpoint,httpMethod,responseType, request, graphName);
    }
}
