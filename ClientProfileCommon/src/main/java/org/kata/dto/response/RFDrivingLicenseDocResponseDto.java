package org.kata.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kata.entity.document.Category;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RFDrivingLicenseDocResponseDto {

    private String uuid;
    private String seriesRDL;
    private String numberRDL;
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
    private String countryName;
    private String issuedBy;
    private Date expiryDate;
    private String experience;
    private String message;
    private Boolean isLegalForce;
    private Collection<Category> category;


}
