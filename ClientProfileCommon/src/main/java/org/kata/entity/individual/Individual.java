package org.kata.entity.individual;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
@ToString
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
    @JsonManagedReference
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //(mappedBy = "individual"****
    @JoinColumn(name = "documents_id")
    private Documents documents;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contacts_id")
    private ContactMedium contacts;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "individual", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Address> address;

}
