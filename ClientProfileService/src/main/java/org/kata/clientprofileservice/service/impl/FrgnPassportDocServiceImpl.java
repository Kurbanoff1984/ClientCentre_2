package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.FrgnPassportDocRepo;
import org.kata.clientprofileservice.service.FrgnPassportDocService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.FrgnPassportDocValidationDto;
import org.kata.entity.document.FrgnPassportDoc;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FrgnPassportDocServiceImpl implements FrgnPassportDocService {

    private final FrgnPassportDocRepo frgnPassportDocRepo;

    private final ModelMapper modelMapper;
    @Override
    public void createFrgnPassportDoc(FrgnPassportDocValidationDto frgnPassportDocValidationDto) {
        frgnPassportDocRepo.save(modelMapper.map(frgnPassportDocValidationDto, FrgnPassportDoc.class));
    }
}
