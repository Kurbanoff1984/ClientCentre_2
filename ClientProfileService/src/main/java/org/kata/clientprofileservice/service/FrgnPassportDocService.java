package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.FrgnPassportDocValidationDto;

public interface FrgnPassportDocService {
    void createFrgnPassportDoc(FrgnPassportDocValidationDto frgnPassportDocValidationDto);
}
