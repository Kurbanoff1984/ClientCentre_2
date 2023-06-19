package com.kata.clientprofilefacade.dao.impl;

import com.kata.clientprofilefacade.dao.IndividualMaskDao;
import com.kata.clientprofilefacade.dto.IndividualDTO;
import com.kata.clientprofilefacade.util.IndividualUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * This class is for surname masking
 *
 * @author Chong Nguyen
 */
@Repository
@Slf4j
public class IndividualMaskImpl implements IndividualMaskDao {

    /**
     * This method first checks that it is null and then masks the last name and changes the full name string
     * @param individual Your Individual object that includes the first name, last name and full name
     * @return Disguised object
     */
    @Override
    public IndividualDTO maskName(IndividualDTO individual) {
        log.info("Surname masking",individual);

        IndividualUtils.fullNameConfirmation(individual);

        individual.setSurname(individual.getSurname().replaceAll("(?<=.).", "*"));

        String[] nameParts = individual.getFullName().split(" ");
        StringBuilder shortenedName = new StringBuilder();

        for (int i = 1; i < nameParts.length; i++) {
            if ( i != 0 && !nameParts[i].isEmpty() && nameParts[i] != null) {
                shortenedName.append(nameParts[i] + " ");
            }
        }
        shortenedName.append(individual.getSurname());

        individual.setFullName(shortenedName.toString());
        return individual;
    }
}
