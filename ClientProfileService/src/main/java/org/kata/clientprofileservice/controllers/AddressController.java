package org.kata.clientprofileservice.controllers;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.AddressValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    @RequestMapping("/createAddress")
    @ValidParams
    public ResponseEntity<AddressValidationDto> createAddress(@RequestBody AddressValidationDto dto) {
        //TODO реализовать запрос через REST в LOADER используя DAO
        //addressService.createAddress(dto);
        return ResponseEntity.ok().body(dto);
    }
}
