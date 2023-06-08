package org.kata.entity.individual;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.kata.entity.contactmedium.ContactMedium;
import org.kata.entity.document.Documents;


import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "individual")
@Entity
public class Individual {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;
    @Column(name = "icp")
    private String icp;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Column(name = "country_of_birth")
    private String countryOfBirth;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "documents")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Documents documents;

    @Column(name = "contacts")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContactMedium contacts;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToMany(mappedBy = "individual", fetch = FetchType.LAZY)
    private Collection<Address> address;

}
