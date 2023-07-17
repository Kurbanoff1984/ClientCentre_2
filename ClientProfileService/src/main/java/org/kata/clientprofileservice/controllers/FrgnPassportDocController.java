package org.kata.clientprofileservice.controllers;


import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.FrgnPassportDocService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.FrgnPassportDocValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frgnPassportDoc")
@RequiredArgsConstructor
public class FrgnPassportDocController {

    private final FrgnPassportDocService service;

    @PostMapping("/createFrgnPassportDoc")
    @ValidParams
    public ResponseEntity<FrgnPassportDocValidationDto> createFrgnPassportDoc(@RequestBody FrgnPassportDocValidationDto dto) {
        service.createFrgnPassportDoc(dto);
        return ResponseEntity.ok().body(dto);
    }
}
