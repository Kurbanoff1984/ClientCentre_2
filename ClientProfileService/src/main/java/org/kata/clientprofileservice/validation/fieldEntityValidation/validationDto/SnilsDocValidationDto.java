package org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.CheckDigitSnils;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.NotEmpty;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RegExp;
import org.kata.util.validation.RegexForField;

@Getter
@Setter
@ToString
public class SnilsDocValidationDto {

    private String uuid;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String receiptDocDate;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String validateDateDoc;
    @NotEmpty
    @RegExp(value = RegexForField.SNILS)
    @CheckDigitSnils
    private String snils;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String issued;
}
