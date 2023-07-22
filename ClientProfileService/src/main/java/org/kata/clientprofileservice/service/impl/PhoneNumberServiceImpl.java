package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.repository.PhoneNumberRepo;
import org.kata.clientprofileservice.service.PhoneNumberService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.PhoneNumberValidationDto;
import org.kata.entity.contactmedium.PhoneNumber;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private final PhoneNumberRepo phoneNumberRepo;

    private final ModelMapper modelMapper;

    @Override
    public void createPhoneNumber(PhoneNumberValidationDto phoneNumberValidationDto) {
        phoneNumberRepo.save(modelMapper.map(phoneNumberValidationDto, PhoneNumber.class));
    }
}
