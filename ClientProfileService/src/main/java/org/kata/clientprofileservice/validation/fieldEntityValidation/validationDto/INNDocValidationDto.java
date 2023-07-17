package org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.*;
import org.kata.util.validation.RegexForField;

@Getter
@Setter
@ToString
public class INNDocValidationDto {
    private String departmentDoc;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String receiptDocDate;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String validateDateDoc;
    @NotEmpty
    @RegExp(RegexForField.INN)
    @CheckDigitINN
    private String inn;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String name;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String patronymic;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String surname;
    @NotEmpty
    @GenderType
    private String gender;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    @RelevanceDate
    private String birthdate;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String issued;
    private String issuedBy;
    private String division;
    @NotEmpty
    @RegExp(value = RegexForField.PLACE_OF_BIRTH_ISSUED_BY)
    private String birthplace;
}
