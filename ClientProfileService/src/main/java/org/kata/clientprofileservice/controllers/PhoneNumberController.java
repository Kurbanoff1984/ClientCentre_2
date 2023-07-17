package org.kata.clientprofileservice.controllers;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.PhoneNumberService;
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
    private final PhoneNumberService service;

    @PostMapping("/createPhoneNumber")
    @ValidParams
    public ResponseEntity<PhoneNumberValidationDto> createPhoneNumber(@RequestBody PhoneNumberValidationDto dto) {
        service.createPhoneNumber(dto);
        return ResponseEntity.ok().body(dto);
    }
}
