package com.kata.clientprofilefacade.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class PhoneNumberErrorForSwagger {
    @Schema(example = "2023-06-07T10:49:48.124+00:00")
    private String timestamp;
    @Schema(example = "500")
    private String status;
    @Schema(example = "Internal Server Error")
    private String error;
    @Schema(example = "Phone number cannot be null or empty")
    private String message;
    @Schema(example = "/api/maskPhoneNumber")
    private String path;






}
