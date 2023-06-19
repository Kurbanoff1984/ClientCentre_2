package com.kata.clientprofilefacade.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class IndividualSuccessForSwagger {

    @Schema(example = "Иван")
    private String name;

    @Schema(example = "И*****")
    private String surname;

    @Schema(example = "Иван Иванович И*****")
    private String fullName;
}
