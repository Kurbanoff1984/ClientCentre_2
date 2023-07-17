package org.kata.clientprofileservice.service;


import org.kata.clientprofileservice.util.statusDto.IndividualStatusDto;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.IndividualValidationDto;
import org.kata.dto.response.IndividualResponseDto;
import org.kata.entity.individual.Individual;


public interface IndividualService {

    void createClient(IndividualValidationDto dto);

    void save(Individual individual);

    Individual getClientByIcp(String icp);

    String getIndividualUuid(String icp);

    IndividualStatusDto findIndividualForVerificationStatus(String id, String type);

}
