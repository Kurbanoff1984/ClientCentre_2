package org.kata.clientprofileservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.INNDocValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/innDoc")
@RequiredArgsConstructor
public class INNDocController {

    @PostMapping("/createInnDoc")
    @ValidParams
    public ResponseEntity<INNDocValidationDto> createINNDoc(@RequestBody INNDocValidationDto dto) {
        //TODO реализовать запрос через REST в LOADER используя DAO
        return ResponseEntity.ok().body(dto);
    }

}
