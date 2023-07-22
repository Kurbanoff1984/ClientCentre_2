package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.RFPassportDocValidationDto;

public interface RFPassportDocService {
    void createRFPassportDoc(RFPassportDocValidationDto rfPassportDoc);
}
