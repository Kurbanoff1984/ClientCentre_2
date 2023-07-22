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
public class IndividualValidationDto {
    private String icp;

    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String name;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String surname;
    @NotEmpty
    @RegExp(value = RegexForField.NAME_SURNAME_PATRONYMIC)
    private String patronymic;

    private String fullName;

    @NotEmpty
    @GenderType
    private String gender;

    @NotEmpty
    @RegExp(value = RegexForField.PLACE_OF_BIRTH_ISSUED_BY)
    private String placeOfBirth;

    private String countryOfBirth;

    @NotEmpty
    @RegExp(value = RegexForField.DATE)
    @RelevanceDate
    private String birthDate;


}
