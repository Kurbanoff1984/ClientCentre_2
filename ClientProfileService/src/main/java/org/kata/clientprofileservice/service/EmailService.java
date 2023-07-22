package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.EmailValidationDto;

public interface EmailService {
    void createEmail(EmailValidationDto emailValidationDto);
}
