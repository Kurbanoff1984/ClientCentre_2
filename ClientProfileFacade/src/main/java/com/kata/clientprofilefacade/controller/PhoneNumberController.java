package com.kata.clientprofilefacade.controller;

import com.kata.clientprofilefacade.dto.PhoneNumberDTO;
import com.kata.clientprofilefacade.service.PhoneNumberMaskService;
import com.kata.clientprofilefacade.util.PhoneNumberErrorForSwagger;
import com.kata.clientprofilefacade.util.PhoneNumberSuccessForSwagger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = "Controller for phone number masking")
public class PhoneNumberController {

    private final PhoneNumberMaskService phoneNumberMaskService;

    @PostMapping("/maskPhoneNumber")
    @Operation(
            summary = "This method is for phone number masking",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = PhoneNumberSuccessForSwagger.class))
                            }
                    ),
                    @ApiResponse(
                            description = "Invalid Phone number",
                            responseCode = "500",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PhoneNumberErrorForSwagger.class)))
            })

    public PhoneNumberDTO maskPhoneNumber(@Valid @RequestBody PhoneNumberDTO phoneNumber) {
        return phoneNumberMaskService.maskPhoneNumber(phoneNumber);
    }
}
