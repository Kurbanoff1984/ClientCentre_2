package org.kata.clientprofileloader.service;

import org.kata.entity.individual.Individual;

public interface IndividualService {

    Individual getClient(String uuid);
}
