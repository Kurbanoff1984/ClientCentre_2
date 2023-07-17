package org.kata.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RFPassportDocResponseDto {

    private String uuid;
    private String seriesRFP;
    private String numberRFP;
    private Date issued;
    private String departmentDoc;
    private Date receiptDocDate;
    private Date validateDateDoc;
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private Date birthdate;
    private String birthplace;
    private String issuedBy;
    private String division;
    private String message;
    private Boolean isLegalForce;
    private String passportStatus;

}
