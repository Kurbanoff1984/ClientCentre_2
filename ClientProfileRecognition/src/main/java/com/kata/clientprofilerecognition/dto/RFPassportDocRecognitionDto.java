package com.kata.clientprofilerecognition.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RFPassportDocRecognitionDto {
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

}
