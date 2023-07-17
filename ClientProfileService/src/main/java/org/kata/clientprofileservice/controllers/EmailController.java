package org.kata.clientprofileservice.controllers;


import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.EmailService;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.ValidParams;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.EmailValidationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/createEmail")
    @ValidParams
    public ResponseEntity<EmailValidationDto> createEmail(@RequestBody EmailValidationDto dto) {
        emailService.createEmail(dto);
        return ResponseEntity.ok().body(dto);
    }
}
