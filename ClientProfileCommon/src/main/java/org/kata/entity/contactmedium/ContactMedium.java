package org.kata.entity.contactmedium;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.kata.entity.individual.Individual;


import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact_medium")
@Entity
public class ContactMedium {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_id")
    private Individual individual;


    @OneToMany(mappedBy = "contactMedium", fetch = FetchType.LAZY)
    private Collection<Email> emails;

    @OneToMany(mappedBy = "contactMedium", fetch = FetchType.LAZY)
    private Collection<PhoneNumber> phoneNumbers;
}
