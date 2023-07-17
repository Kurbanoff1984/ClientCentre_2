package org.kata.clientprofileservice.controllers;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.SnilsDocService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.SnilsDocValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/snilsDoc")
public class SnilsDocController {

    private final SnilsDocService service;

    @PostMapping("/createSnilsDoc")
    @ValidParams
    public ResponseEntity<SnilsDocValidationDto> createSnilsDoc(@RequestBody SnilsDocValidationDto dto) {
        service.createSnilsDoc(dto);
        return ResponseEntity.ok().body(dto);
    }

}
