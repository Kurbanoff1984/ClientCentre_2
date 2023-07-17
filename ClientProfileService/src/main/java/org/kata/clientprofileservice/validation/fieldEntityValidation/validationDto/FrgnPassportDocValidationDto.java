package org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.GenderType;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.NotEmpty;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RegExp;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RelevanceDate;
import org.kata.util.validation.RegexForField;

import java.util.Date;

@Getter
@Setter
@ToString
public class FrgnPassportDocValidationDto {
    @NotEmpty
    @RegExp(value = RegexForField.SERIES_FP)
    private String seriesFP;
    @NotEmpty
    @RegExp(value = RegexForField.NUMBER_FP)
    private String numberFP;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    @RelevanceDate
    private String issued;

    private String departmentDoc;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    @RelevanceDate
    private String receiptDocDate;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    @RelevanceDate
    private String validateDateDoc;
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
    @RegExp(value = RegexForField.PLACE_OF_BIRTH_ISSUED_BY)
    private String birthplace;
    @NotEmpty
    @RegExp(value = RegexForField.PLACE_OF_BIRTH_ISSUED_BY)
    private String issuedBy;

    private String latinName;

    private String latinSurname;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    @RelevanceDate
    private String expiryDate;

    private String division;

    private String message;

    private Boolean isLegalForce;

    private String passportStatus;
}
