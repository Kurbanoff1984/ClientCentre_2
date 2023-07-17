package org.kata.clientprofileservice.util.statusDto;

import lombok.*;
import org.kata.dto.response.AddressResponseDto;
import org.kata.dto.response.ContactMediumResponseDto;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.enums.IndividualStatus;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IndividualStatusDto {

    private String name;

    private String surname;

    private String patronymic;

    private String fullName;

    private String gender;

    private String placeOfBirth;

    private String countryOfBirth;

    private Date birthDate;

    private IndividualStatus status;

    private LocalDateTime dateStatus;

    private DocumentsResponseDto documents;

    private ContactMediumResponseDto contacts;

    private Collection<AddressResponseDto> address;




}
