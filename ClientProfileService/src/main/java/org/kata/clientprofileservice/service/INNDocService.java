package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.INNDocValidationDto;

public interface INNDocService {
    void createINNDoc(INNDocValidationDto innDoc);
}
