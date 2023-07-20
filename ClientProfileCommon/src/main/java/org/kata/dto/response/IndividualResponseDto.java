package org.kata.dto.response;


import lombok.*;
import org.kata.enums.IndividualStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private IndividualStatus status;

    private LocalDateTime dateStatus;

}
