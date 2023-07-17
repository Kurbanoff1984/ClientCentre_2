package org.kata.entity.document;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rf_passport")
@Entity
public class RFPassportDoc {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;

    @Column(name = "series", nullable = false)
    private String seriesRFP;

    @Column(name = "number", nullable = false)
    private String numberRFP;

    @Column(name = "issued_date")
    @Temporal(value = TemporalType.DATE)
    private Date issued;

    @Column(name = "department")
    private String departmentDoc;

    @Column(name = "receipt_date")
    @Temporal(value = TemporalType.DATE)
    private Date receiptDocDate;

    @Column(name = "validate_date")
    @Temporal(value = TemporalType.DATE)
    private Date validateDateDoc;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "gender")
    private String gender;

    @Temporal(value = TemporalType.DATE)
    private Date birthdate;

    @Column(name = "birthplace")
    private String birthplace;
    @Column(name = "issuedBy")
    private String issuedBy;
    @Column(name = "division")
    private String division;
    @Column(name = "message")
    private String message;
    @Column(name = "legal_force")
    private Boolean isLegalForce;
    @Column(name = "passport_status")
    private String passportStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Documents documents;
}


