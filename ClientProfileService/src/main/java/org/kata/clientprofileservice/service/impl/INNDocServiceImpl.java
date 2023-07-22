package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.INNDocRepo;
import org.kata.clientprofileservice.service.INNDocService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.INNDocValidationDto;
import org.kata.entity.document.INNDoc;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class INNDocServiceImpl implements INNDocService {

    private final INNDocRepo innDocRepo;
    private final ModelMapper modelMapper;

    @Override
    public void createINNDoc(INNDocValidationDto innDoc) {
        innDocRepo.save(modelMapper.map(innDoc, INNDoc.class));
    }
}
