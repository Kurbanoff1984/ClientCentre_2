package org.kata.clientprofileservice.service.impl;

import lombok.AllArgsConstructor;
import org.kata.clientprofileservice.repository.SnilsDocRepo;
import org.kata.clientprofileservice.service.SnilsDocService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.SnilsDocValidationDto;
import org.kata.entity.document.SNILSDoc;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SnilsDocServiceImpl implements SnilsDocService {
    private final ModelMapper modelMapper;
    private final SnilsDocRepo  snilsDocRepo;
    @Override
    public void createSnilsDoc(SnilsDocValidationDto dto)  {
        snilsDocRepo.save(modelMapper.map(dto, SNILSDoc.class));
    }
}
