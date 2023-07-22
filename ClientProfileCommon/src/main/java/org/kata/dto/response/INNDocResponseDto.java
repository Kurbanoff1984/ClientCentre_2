package org.kata.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class INNDocResponseDto {
    private String uuid;
    private String departmentDoc;
    private Date receiptDocDate;
    private Date validateDateDoc;
    private String inn;
    private String name;
    private String patronymic;
    private String surname;
    private String gender;
    private Date birthdate;
    private Date issued;
    private String issuedBy;
    private String division;
    private String birthplace;

}
