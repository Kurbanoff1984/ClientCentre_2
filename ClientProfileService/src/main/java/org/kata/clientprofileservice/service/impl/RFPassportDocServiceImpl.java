package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.RFPassportDocRepo;
import org.kata.clientprofileservice.service.RFPassportDocService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.RFPassportDocValidationDto;
import org.kata.entity.document.RFPassportDoc;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RFPassportDocServiceImpl implements RFPassportDocService {
    private final ModelMapper modelMapper;
    private final RFPassportDocRepo rfPassportDocRepo;
    @Override
    public void createRFPassportDoc(RFPassportDocValidationDto rfPassportDoc) {
        rfPassportDocRepo.save(modelMapper.map(rfPassportDoc, RFPassportDoc.class));
    }
}
