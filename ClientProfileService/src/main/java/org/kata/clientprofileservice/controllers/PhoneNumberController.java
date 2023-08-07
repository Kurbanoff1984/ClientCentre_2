package org.kata.clientprofileservice.controllers;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.PhoneNumberValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phoneNumber")
@RequiredArgsConstructor
public class PhoneNumberController {

    @PostMapping("/createPhoneNumber")
    @ValidParams
    public ResponseEntity<PhoneNumberValidationDto> createPhoneNumber(@RequestBody PhoneNumberValidationDto dto) {
        //TODO реализовать запрос через REST в LOADER используя DAO
        return ResponseEntity.ok().body(dto);
    }
}
