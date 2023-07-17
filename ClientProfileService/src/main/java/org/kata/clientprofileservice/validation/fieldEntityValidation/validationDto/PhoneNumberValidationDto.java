package org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.NotEmpty;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RegExp;
import org.kata.util.validation.RegexForField;

@Getter
@Setter
@ToString
public class PhoneNumberValidationDto {
    @NotEmpty
    @RegExp(value = RegexForField.PHONE_NUMBER)
    private String valuePhone;
}
