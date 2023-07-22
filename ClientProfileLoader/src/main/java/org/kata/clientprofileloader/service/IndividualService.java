package org.kata.clientprofileloader.service;

import org.kata.entity.individual.Individual;

public interface IndividualService {

    Individual getClient(String uuid);
    Individual findIndividual (String id, String type);
    Individual saveIndividual(Individual individual);
}
