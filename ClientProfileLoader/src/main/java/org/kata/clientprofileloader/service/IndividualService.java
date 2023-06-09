package org.kata.clientprofileloader.service;

import org.kata.clientprofileloader.entity.Individual;

public interface IndividualService {
    Individual findIndividual (String id, String type);
    Individual saveIndividual(Individual individual);
}
