package org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.GenderType;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.NotEmpty;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RegExp;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationAnnotation.RelevanceDate;
import org.kata.util.validation.RegexForField;


@Getter
@Setter
@ToString
public class RFPassportDocValidationDto {
    @NotEmpty
    @RegExp(value = RegexForField.SERIES_RFP)
    private String seriesRFP;
    @NotEmpty
    @RegExp(value = RegexForField.NUMBER_RFP)
    private String numberRFP;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    @RelevanceDate
    private String issued;
    private String departmentDoc;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String receiptDocDate;
    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    private String validateDateDoc;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String name;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String surname;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String patronymic;
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
    @NotEmpty
    @RegExp(value = RegexForField.DIVISION)
    private String division;
    private String message;
    private Boolean isLegalForce;
    private String passportStatus;
}
