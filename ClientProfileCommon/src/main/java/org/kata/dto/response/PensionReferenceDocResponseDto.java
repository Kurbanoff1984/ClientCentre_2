package org.kata.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionReferenceDocResponseDto {

    private String uuid;
    private Date receiptDocDate;
    private Date validateDateDoc;
    private String departmentDoc;
    private String birthPlace;
    private String birthDate;
    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private String docVersion;
    private Date getDateDoc;
}
