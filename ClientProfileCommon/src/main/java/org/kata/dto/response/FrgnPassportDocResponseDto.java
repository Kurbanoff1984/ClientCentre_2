package org.kata.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FrgnPassportDocResponseDto {

    private String uuid;

    private String series;

    private String number;

    private Date issued;

    private String departmentDoc;

    private Date receiptDocDate;

    private Date validateDateDoc;

    private String name;

    private String patronymic;

    private String surname;

    private String gender;

    private Date birthdate;

    private String birthplace;

    private String issuedBy;

    private String latinName;

    private String latinSurname;
    private Date expiryDate;

    private String division;

    private String message;

    private Boolean isLegalForce;

    private String passportStatus;

}
