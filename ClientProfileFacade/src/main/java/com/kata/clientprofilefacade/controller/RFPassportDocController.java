package com.kata.clientprofilefacade.controller;

import com.kata.clientprofilefacade.dto.RFPassportDocDTO;
import com.kata.clientprofilefacade.service.RFPassportDocMaskService;
import com.kata.clientprofilefacade.util.RFPassportDocErrorForSwagger;
import com.kata.clientprofilefacade.util.RFPassportDocSuccessForSwagger;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = "Controller for passport masking")
public class RFPassportDocController {

    private final RFPassportDocMaskService rfPassportDocMaskService;

    @PostMapping("/maskPassport")
    @Operation(
            summary = "This method is for passport masking",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = RFPassportDocSuccessForSwagger.class))
                            }
                    ),
                    @ApiResponse(
                            description = "Invalid Full name",
                            responseCode = "500",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = RFPassportDocErrorForSwagger.class)))
            })
    public RFPassportDocDTO maskPassport(@Valid @RequestBody RFPassportDocDTO rfPassportDoc) {
        return rfPassportDocMaskService.maskPassport(rfPassportDoc);
    }
}
