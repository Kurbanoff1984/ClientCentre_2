package org.kata.clientprofileservice.util.testDto;

import lombok.*;
import org.kata.entity.individual.Address;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestDataIndividualDto {

    private String icp;
    private String name;
    private String surname;
    private Date birthDate;
    private String patronymic;
    private String countryOfBirth;
    private String fullName;
    private String gender;
    private String placeOfBirth;
    private Collection<Address> address;

    {
        fullName = name + " " + patronymic + " " + surname;
    }

    public static class TestDataIndividualDtoBuilder {
        public TestDataIndividualDtoBuilder icp(String icp) {
            if (!validateIndividual(icp)) {
                throw new IllegalArgumentException("Sorry! TestDataIndividual objects can't be build without required details.");
            }
            this.icp = icp;
            return this;
        }

        private boolean validateIndividual(String icp) {
            return (icp != null && !icp.trim().isEmpty());
        }
    }
}




