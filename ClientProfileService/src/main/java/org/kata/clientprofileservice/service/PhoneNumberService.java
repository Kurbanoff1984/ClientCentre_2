package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.PhoneNumberValidationDto;

public interface PhoneNumberService {
    void createPhoneNumber(PhoneNumberValidationDto phoneNumberValidationDto);
}
