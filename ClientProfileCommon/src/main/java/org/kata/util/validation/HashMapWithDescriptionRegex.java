package org.kata.util.validation;


import lombok.Getter;



import java.util.HashMap;
import java.util.Map;

/**
 * Утильный класс содержащий регулярные выражения для полей классов, используется в RegularExpressionValidatorImpl при валидации
 */
@Getter
public class HashMapWithDescriptionRegex {
    private final Map<String, String> regex;


    public HashMapWithDescriptionRegex() {
        this.regex = new HashMap<>();
        regex.put("name", "Field name must include Cyrillic characters, the following characters are also allowed: \", ', -, space.");
        regex.put("surname", "Field surname must include Cyrillic characters, the following characters are also allowed: \", ', -, space.");
        regex.put("patronymic", "Field patronymic must include Cyrillic characters, the following characters are also allowed: \", ', -, space.");
        regex.put("placeOfBirth", "Field placeOfBirth must include Cyrillic characters, the following characters are also allowed: \", ', -, ., space." +
                "It is not allowed to use as the first: -, ', space, .");
        regex.put("birthplace", "Field birthplace must include Cyrillic characters, the following characters are also allowed: \", ', -, ., space." +
                "It is not allowed to use as the first: -, ', space, .");
        regex.put("birthdate", "The date must follow the format «ДД.ММ.ГГГГ».");
        regex.put("birthDate", "The date must follow the format «ДД.ММ.ГГГГ».");
        regex.put("snils", "Snils must match the format \"xxx-xxx-xxx xxx\".");
        regex.put("receiptDocDate", "The date must follow the format «ДД.ММ.ГГГГ».");
        regex.put("validateDateDoc", "The date must follow the format «ДД.ММ.ГГГГ».");
        regex.put("issued", "The date must follow the format «ДД.ММ.ГГГГ».");
        regex.put("inn", "Inn must be 12 digits.");
        regex.put("issuedBy", "Field issuedBy must include Cyrillic characters, the following characters are also allowed: \", ', -, ., space." +
                "It is not allowed to use as the first: -, ', space, .");
        regex.put("division", "The division code must follow the format 999-999. Field coverage of digits in all six characters is not allowed");
        regex.put("seriesRFP", "The passport must match the pattern: 4 digits (let's say a space between the 2nd and 3rd digit) " +
                "The Russian passport series cannot start with the numbers: \"00\", \"02\", \"06\", \"13\", \"16\", \"21\", \" 23\", \"31\".");
        regex.put("numberRFP", "The passport number must contain 6 digits.");
        regex.put("addressName", "The addressName field contains Cyrillic letters and numbers, it is also acceptable to use delimiters");
        regex.put("seriesFP", "The passport series must consist of two digits except for 80, 81, 82, 83.");
        regex.put("numberFP", "Passport number must be 7 digits.");
        regex.put("valuePhone", "Phone number must start with a 7 followed by 10 digits.");
        regex.put("valueEmail", "Mail must consist of letters of the Latin alphabet as well as numbers, it is permissible to use (.) , (%), (_).");

    }
}
