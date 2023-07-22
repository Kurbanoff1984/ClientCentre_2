package org.kata.clientprofileservice.service;

import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.AddressValidationDto;
import org.kata.dto.response.AddressResponseDto;

public interface AddressService {
    void createAddress(AddressValidationDto addressValidationDto);
    AddressResponseDto getAddress(String icp);

}
