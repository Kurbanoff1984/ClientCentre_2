package com.kata.clientprofilefacade.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualDTO {

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 2,max = 50, message = "Name must be between 2 and 50 letters")
    @Schema(example = "Иван")
    String name;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 2,max = 50, message = "Surname must be between 2 and 50 letters")
    @Schema(example = "Иванов")
    String surname;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 10,max = 100, message = "FullName must be between 2 and 100 letters")
    @Schema(example = "Иванов Иван Иванович")
    String fullName;
}
