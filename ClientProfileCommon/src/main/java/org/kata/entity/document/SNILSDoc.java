package org.kata.entity.document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "snils_doc")
public class SNILSDoc {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;

    @Column(name = "receipt_date")
    @Temporal(TemporalType.DATE)
    private Date receiptDocDate;

    @Column(name = "validate_date")
    @Temporal(TemporalType.DATE)
    private Date validateDateDoc;

    private String snils;

    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issued;
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Documents documents;
}
