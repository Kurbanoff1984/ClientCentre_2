package org.kata.clientprofileservice.util.creational.testData;

import org.kata.clientprofileservice.util.creational.abstractFactory.GeneratorIndividualTestData;
import org.kata.clientprofileservice.util.enums.individuaInfo.*;
import org.kata.clientprofileservice.util.testDto.TestDataIndividualDto;
import org.kata.entity.individual.Individual;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class IndividualData implements GeneratorIndividualTestData {

    private final List<NameIndividual> nameIndividuals = List.of(NameIndividual.values());
    private final List<SurnameIndividual> surnameIndividuals = List.of(SurnameIndividual.values());
    private final List<PatronymicIndividual> patronymicIndividuals = List.of(PatronymicIndividual.values());
    private final List<CountryOfBirth> countryOfBirths = List.of(CountryOfBirth.values());
    private final List<GenderIndividual> genderIndividuals = List.of(GenderIndividual.values());
    private final List<PlaceOfBirth> placeOfBirths = List.of(PlaceOfBirth.values());

    @Override
    public Individual generateRandomIndividual() {
        ModelMapper modelMapper = new ModelMapper();
        Random random = new Random();
        String nameRandom = nameIndividuals.get(random.nextInt(nameIndividuals.size())).toStringName();
        String patronymicRandom = patronymicIndividuals.get(random.nextInt(patronymicIndividuals.size())).toStringPatronymic();
        String surnameRandom = surnameIndividuals.get(random.nextInt(surnameIndividuals.size())).toStringSurname();

        TestDataIndividualDto test = TestDataIndividualDto.builder()
                .icp(String.valueOf(random.nextInt(900000) + 100000))
                .name(nameRandom)
                .surname(surnameRandom)
                .birthDate(getRandomDate())
                .patronymic(patronymicRandom)
                .countryOfBirth(countryOfBirths.get(random.nextInt(countryOfBirths.size())).toStringCountry())
                .fullName(nameRandom + " " + patronymicRandom + " " + surnameRandom)
                .gender(genderIndividuals.get(random.nextInt(genderIndividuals.size())).toStringGender())
                .placeOfBirth(placeOfBirths.get(random.nextInt(placeOfBirths.size())).toStringPlace())
                .build();

        return modelMapper.map(test, Individual.class);
    }

    protected Date getRandomDate() {
        Random random = new Random();
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, random.nextInt(50) + 1965);
        calendar.set(Calendar.MONTH, random.nextInt(12));
        calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1);
        return calendar.getTime();
    }
}
