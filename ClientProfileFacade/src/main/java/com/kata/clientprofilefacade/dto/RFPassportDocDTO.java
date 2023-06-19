package com.kata.clientprofilefacade.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RFPassportDocDTO {

    @NotEmpty
    @NotBlank
    @Positive
    @NotNull
    @Pattern(regexp = "\\d{4}", message = "Series must consist of 4 digits")
    @Schema(example = "2134")
    private String series;

    @NotEmpty
    @NotBlank
    @Positive
    @NotNull
    @Pattern(regexp = "\\d{6}", message = "Series must consist of 6 digits")
    @Schema(example = "357263")
    private String number;
}
