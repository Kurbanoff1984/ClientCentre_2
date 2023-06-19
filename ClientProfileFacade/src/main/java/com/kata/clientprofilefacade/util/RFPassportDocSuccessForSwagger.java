package com.kata.clientprofilefacade.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RFPassportDocSuccessForSwagger {

    @Schema(example = "21**")
    private String series;
    @Schema(example = "****63")
    private String number;
}
