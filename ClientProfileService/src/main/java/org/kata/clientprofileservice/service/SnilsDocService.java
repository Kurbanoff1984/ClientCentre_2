package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.SnilsDocValidationDto;

public interface SnilsDocService {

    void createSnilsDoc(SnilsDocValidationDto snilsDoc);
}
