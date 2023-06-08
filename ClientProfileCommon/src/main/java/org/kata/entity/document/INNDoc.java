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
@Table(name = "rf_driving_license")
@Entity
public class INNDoc {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;
    @Column(name = "department")
    private String departmentDoc;
    @Column(name = "receipt_date")
    @Temporal(value = TemporalType.DATE)
    private Date receiptDocDate;
    @Column(name = "validate_date")
    @Temporal(value = TemporalType.DATE)
    private Date validateDateDoc;
    private String inn;
    private String name;
    private String patronymic;
    private String surname;
    private String gender;
    @Temporal(value = TemporalType.DATE)
    private Date birthdate;
    @Temporal(value = TemporalType.DATE)
    private Date issued;
    private String issuedBy;
    private String division;
    private String birthplace;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Documents documents;
}
