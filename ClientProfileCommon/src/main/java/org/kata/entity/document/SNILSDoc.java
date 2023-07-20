package org.kata.entity.document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Getter
@Setter
@ToString
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
