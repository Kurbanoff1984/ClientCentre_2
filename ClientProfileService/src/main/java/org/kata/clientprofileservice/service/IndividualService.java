package org.kata.clientprofileservice.service;


import org.kata.dto.response.IndividualResponseDto;
import org.kata.entity.individual.Individual;


public interface IndividualService {

    void createClient(Individual individual);

    Individual getClientByIcp(String icp);

    String getIndividualUuid(String icp);

    IndividualResponseDto findIndividual(String id, String type);

}
