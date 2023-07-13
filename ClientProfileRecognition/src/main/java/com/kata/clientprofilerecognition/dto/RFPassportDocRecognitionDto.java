package com.kata.clientprofilerecognition.dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RFPassportDocRecognitionDto {
    // внедрил поле icp для отправки
    @Id
    private String icp;
    private String surname;
    private String name;
    private String patronymic;
    private String gender;
    private String birthdate;
    private String birthplace;
    private String series;
    private String number;
    private String issuedBy;
    private String issuedDate;
    private String division;
    //для написания логики получения статуса
    private boolean clientStatus;

}
