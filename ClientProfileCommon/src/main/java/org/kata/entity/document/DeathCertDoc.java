package org.kata.entity.document;

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
@Table(name = "death_cert")
public class DeathCertDoc {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;

    private String message;

    @Column(nullable = false)
    private String series;

    @Column(nullable = false)
    private String number;

    @Column(name = "issued_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date issued;

    @Column(name = "department")
    private String departmentDoc;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date getDateDoc;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    private Documents documents;


}

