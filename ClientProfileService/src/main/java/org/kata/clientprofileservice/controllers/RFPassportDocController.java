package org.kata.clientprofileservice.controllers;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.RFPassportDocService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.RFPassportDocValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rFPassportDoc")
@RequiredArgsConstructor
public class RFPassportDocController {
    private final RFPassportDocService service;

    @PostMapping("/createRFPassport")
    @ValidParams
    public ResponseEntity<RFPassportDocValidationDto> createRFPassportDoc(@RequestBody RFPassportDocValidationDto dto) {
        service.createRFPassportDoc(dto);
        return ResponseEntity.ok().body(dto);
    }
}
