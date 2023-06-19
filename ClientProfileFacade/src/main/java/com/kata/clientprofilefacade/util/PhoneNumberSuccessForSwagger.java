package com.kata.clientprofilefacade.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PhoneNumberSuccessForSwagger {
    private String uuid;

    @Schema(example = "+7 934 ***-**-42")
    private String value;
}
