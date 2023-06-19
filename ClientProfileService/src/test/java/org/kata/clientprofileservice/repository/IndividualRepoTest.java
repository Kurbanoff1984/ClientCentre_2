package org.kata.clientprofileservice.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kata.clientprofileservice.service.projection.IndividualUuidProjection;
import org.kata.entity.individual.Individual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, value = "/db/scripts/after.sql")
public class IndividualRepoTest {
    @Autowired
    private IndividualRepo individualRepo;

    private Individual firstIndividual;

    private Individual secondIndividual;



    @BeforeEach
    void init() {
        firstIndividual = new Individual();
        firstIndividual.setIcp("10");
        firstIndividual.setName("Sasha");
        firstIndividual.setSurname("Perepelkin");
        firstIndividual.setPatronymic("Alekseevich");
        individualRepo.save(firstIndividual);

        secondIndividual = new Individual();
        secondIndividual.setIcp("20");
        secondIndividual.setName("Andrew");
        secondIndividual.setSurname("Eremenko");
        secondIndividual.setPatronymic("Olegovich");
        individualRepo.save(secondIndividual);
    }

    @Test
    @DisplayName("Checks if the user with the given icp exists in the database")
    void existIndividualWithThisIcp() {
        boolean check = individualRepo.existByIcp("10");
        Individual existIndividual = individualRepo.findIndividualByIcp("10").get();
        assertNotNull(existIndividual);
        assertEquals("Sasha", existIndividual.getName());
        assertEquals("10", existIndividual.getIcp());
        assertEquals("Perepelkin", existIndividual.getSurname());
        assertEquals("Alekseevich", existIndividual.getPatronymic());
        assertTrue(check);
    }

    @Test
    @DisplayName("Finds the uuid of a user by his icp")
    void getUuidIndividualByIcp()  {
        String uuid = individualRepo.findUuidByIcp("10").stream().map(IndividualUuidProjection::getUuid)
                                                        .findFirst()
                                                        .orElse(null);

        Individual existIndividual = individualRepo.findIndividualByUuid(uuid).get();
        assertNotNull(uuid);
        assertNotNull(existIndividual);
        assertEquals("10", existIndividual.getIcp());
    }
}
