package com.kata.clientprofilefacade.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.kata.clientprofilefacade.constant.PhoneNumberRegExp.PHONE_NUMBER_FORMAT;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDTO {

    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = PHONE_NUMBER_FORMAT, message = "Phone number must be in this format \"+7 xxx xxx-xx-xx\"")
    @Size(min = 2,max = 50)
    @Schema(example = "+7 934 424-42-42")
    private String value;
}
