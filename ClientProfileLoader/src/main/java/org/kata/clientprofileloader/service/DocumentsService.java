package org.kata.clientprofileloader.service;

import org.kata.dto.response.DocumentsResponseDto;
import org.kata.entity.individual.Individual;


public interface DocumentsService {

    DocumentsResponseDto getDocumentsByUuidIndividual(String uuidInd);

    void createNewDocumentsForIndividual(Individual individual);


}
