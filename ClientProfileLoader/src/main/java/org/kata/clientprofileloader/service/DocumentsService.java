package org.kata.clientprofileloader.service;

import org.kata.dto.response.DocumentsResponseDto;
import org.kata.dto.response.IndividualResponseDto;


public interface DocumentsService {

    DocumentsResponseDto getDocumentsByUuidIndividual(String uuidInd);

    void createNewDocumentsForIndividual(IndividualResponseDto individual);


}
