package org.kata.dto.response;


import lombok.*;
import org.kata.entity.contactmedium.ContactMedium;
import org.kata.entity.individual.Address;
import org.kata.entity.individual.Avatar;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndividualResponseDto {

    private String uuid;

    private String icp;

    private String name;

    private String surname;

    private String patronymic;

    private String fullName;

    private String gender;

    private String placeOfBirth;

    private String countryOfBirth;

    private Date birthDate;

//    private DocumentsResponseDto documents;

//    private ContactMedium contacts;

//    private Avatar avatar;
//
//    private Collection<Address> address;
}
