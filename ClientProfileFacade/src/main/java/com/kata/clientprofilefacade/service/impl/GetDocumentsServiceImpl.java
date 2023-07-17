package com.kata.clientprofilefacade.service.impl;

import com.kata.clientprofilefacade.dao.GetDocumentsDao;
import com.kata.clientprofilefacade.service.GetDocumentsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetDocumentsServiceImpl implements GetDocumentsService {

    private final GetDocumentsDao getDocumentsDao;

    @Override
    public <T> ResponseEntity<T> giveDocuments(String token, String uuid, HttpServletRequest request, String graphName) {
        return getDocumentsDao.giveDocuments(token,uuid,request,graphName);
    }
}
