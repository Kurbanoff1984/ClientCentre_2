package com.kata.clientprofilerecognition.service.task29;

import com.kata.clientprofilerecognition.dto.RFPassportDocRecognitionDto;
import com.kata.clientprofilerecognition.service.task29.clientService.ClientService;
import com.kata.clientprofilerecognition.service.task29.service.Loader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Сервис проверяет статус клиента и вызывает соответсвующие методы
 */
@Service
@AllArgsConstructor
@Slf4j
public class ClientStatusChecker {
    private final ClientService clientService;

//метод проверяет статус клиента
    public void checkClientStatus(RFPassportDocRecognitionDto newDocument) {
        try {
            switch (newDocument.getClientStatus()) {
                case DOCUMENTS_UPLOADED:
                    log.info("Документ загружен");
                    break;
                case NEED_DOCUMENT:
                    clientService.addClientDocument(newDocument);
                    break;
                case NEED_UPDATE_DOCUMENT:
                    clientService.compareAndUploadDocument(newDocument);
                    break;
            }
        } catch (Exception e) {
            log.error("Произошла ошибка при проверке статуса клиента: {}", e.getMessage());

        }
    }


}
