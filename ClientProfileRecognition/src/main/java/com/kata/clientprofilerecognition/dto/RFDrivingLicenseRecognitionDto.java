package com.kata.clientprofilerecognition.dto;


import java.util.Collection;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RFDrivingLicenseRecognitionDto {
    private String seriesRDL;
    private String numberRDL;
    private String issued;
    private String name;
    private String patronymic;
    private String surname;
    private String birthdate;
    private String birthplace;
    private String issuedBy;
    private String expiryDate;
    private String location;
    private Collection<String> category;
}
