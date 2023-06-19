package org.kata.clientprofileloader.service.Impl;

import lombok.AllArgsConstructor;
import org.kata.clientprofileloader.repository.DocumentsRepo;
import org.kata.clientprofileloader.repository.IndividualRepo;
import org.kata.clientprofileloader.service.DocumentsService;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.entity.document.Documents;
import org.kata.entity.individual.Individual;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


/**
 * Сервис класс для бизнес-логики с Documents
 */
@Service
@AllArgsConstructor
public class DocumentsServiceImpl implements DocumentsService {
    private final DocumentsRepo documentsRepo;
    private final IndividualRepo individualRepo;
    private final ModelMapper modelMapper;

    /**
     * Метод для получения документов в формате DocumentsResponseDto по uuid пользователя
     * @param uuidInd
     * @return DocumentsResponseDto
     */

    @Override
    public DocumentsResponseDto getDocumentsByUuidIndividual(String uuidInd) {
        Documents documents = documentsRepo.getDocumentsByUuidIndividual(uuidInd);
        DocumentsResponseDto documentsResponseDto = modelMapper.map(documents, DocumentsResponseDto.class);
        return documentsResponseDto;
    }


    /**
     * Метод для создания Documents пользователя
     * @param individual
     */
    @Override
    public void createNewDocumentsForIndividual(Individual individual) {
        Documents documents = new Documents();
        documents.setIndividual(individual);
        individual.setDocuments(documents);
        individualRepo.save(individual);
    }


}
