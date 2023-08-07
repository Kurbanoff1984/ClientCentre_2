package org.kata.clientprofileloader.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.kata.clientprofileloader.service.DocumentsService;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.dto.response.IndividualResponseDto;
import org.kata.entity.document.Documents;
import org.kata.repository.DocumentsRepository;
import org.springframework.stereotype.Service;


/**
 * Сервис класс для бизнес-логики с Documents
 */
@Service
@AllArgsConstructor
public class DocumentsServiceImpl implements DocumentsService {

    private final DocumentsRepository documentsRepository;

    private final ObjectMapper modelMapper;

    /**
     * Метод для получения документов в формате DocumentsResponseDto по uuid пользователя
     * @param uuidInd
     * @return DocumentsResponseDto
     */

    @Override
    public DocumentsResponseDto getDocumentsByUuidIndividual(String uuidInd) {
        Documents documents = documentsRepository.getReferenceById(uuidInd);
        DocumentsResponseDto documentsResponseDto = modelMapper.convertValue(documents, DocumentsResponseDto.class);
        return documentsResponseDto;
    }


    /**
     * Метод для создания Documents пользователя
     * @param individual
     */
    @Override
    public void createNewDocumentsForIndividual(IndividualResponseDto individual) {
        Documents documents = new Documents();
    }


}
