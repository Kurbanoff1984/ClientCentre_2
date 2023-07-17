package org.kata.entity.contactmedium;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emails")
@Entity
public class Email {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactMedium contactMedium;

    @Column(name = "email")
    private String valueEmail;
}
