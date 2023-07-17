package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.EmailRepo;
import org.kata.clientprofileservice.service.EmailService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.EmailValidationDto;
import org.kata.entity.contactmedium.Email;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepo emailRepo;

    private final ModelMapper modelMapper;
    @Override
    public void createEmail(EmailValidationDto emailValidationDto) {
        emailRepo.save(modelMapper.map(emailValidationDto, Email.class));
    }
}
