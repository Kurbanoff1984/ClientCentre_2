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
public class AddressValidationDto {

    @NotEmpty
    @RegExp(value = RegexForField.ADDRESS_NAME)
    private String addressName;
    private String country;
    private String zipCode;
    private String province;
    private String provinceType;
    private String region;
    private String regionType;
    private String city;
    private String cityType;
    private String settlement;
    private String settlementType;
    private String street;
    private String streetType;
    private String additionAreaStreet;
    private String house;
    private String housing;
    private String building;
}
