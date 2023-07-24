package com.kata.clientprofileavatar.entity.entityAvatar;




import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.kata.entity.contactmedium.ContactMedium;
import org.kata.entity.document.Documents;
import org.kata.entity.individual.Address;
import org.kata.entity.individual.Avatar;


import java.util.Collection;
import java.util.Date;

@Data
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
    @Column(name = "arxivStatys")
    private Boolean arxivStatys;


}
