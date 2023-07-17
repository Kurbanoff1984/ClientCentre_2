package org.kata.entity.contactmedium;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "phone_numbers")
@Entity
public class PhoneNumber {

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactMedium contactMedium;

    @Column(name = "phone")
    private String valuePhone;

}
