package org.kata.entity.document;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UuidGenerator;
import org.kata.entity.individual.Individual;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documents")
@Entity
public class Documents {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE) //******************************
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_id")
    private Individual individual;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DeathCertDoc deathCertDocs;

    @OneToMany(mappedBy = "documents", fetch = FetchType.LAZY)
    private Collection<FrgnPassportDoc> frgnPassportDocs;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private INNDoc innDoc;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PensionReferenceDoc pensionReferenceDoc;

    @OneToMany(mappedBy = "documents", fetch = FetchType.LAZY)
    private Collection<RFDrivingLicenseDoc> rfDrivingLicenseDoc;

    @OneToMany(mappedBy = "documents", fetch = FetchType.LAZY)
    private Collection<RFPassportDoc> rfPassportDocs;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SNILSDoc snilsDoc;


}
