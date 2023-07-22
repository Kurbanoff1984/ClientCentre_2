package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.DocumentsRepo;
import org.kata.clientprofileservice.service.DocumentsService;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.entity.document.Documents;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentsServiceIml implements DocumentsService {
    private final DocumentsRepo documentsRepo;
    private final ModelMapper modelMapper;

    @Override
    public DocumentsResponseDto getDocuments(String icp) {
        Optional<Documents> documents = documentsRepo.findByUserIcp(icp);
        return documents.map(value -> modelMapper.map(value, DocumentsResponseDto.class)).orElse(null);

    }
}
