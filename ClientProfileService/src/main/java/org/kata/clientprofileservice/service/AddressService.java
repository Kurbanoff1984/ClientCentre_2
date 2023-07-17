package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.AddressValidationDto;

public interface AddressService {
    void createAddress(AddressValidationDto addressValidationDto);
}
