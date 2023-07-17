package org.kata.clientprofileloader.service;

import com.google.protobuf.ServiceException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.kata.entity.document.Documents;
import org.kata.repository.DocumentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Этот сервис отвечает за выполнение операций получения, добавления, обновления и
 * удаления конкретного документа и получить список документов клиента
 */

@Service
@AllArgsConstructor
@Slf4j
public class DocumentService {
    private final DocumentsRepository documentsRepository;

    //получить все документы
    @SneakyThrows
    public List<Documents> getClientDocuments(String uuid) {
        try {
            return documentsRepository.findAllByUuid(uuid);
        } catch (Exception e) {
            log.error("Ошибка при получении списка документов для клиента с UUID: {}", uuid, e);
            throw new ServiceException("Ошибка при получении списка документов для клиента");
        }
    }

    // получить конкретный документ
    @SneakyThrows
    public Optional<Documents> getClientDocument(String uuid) {
        try {
            return documentsRepository.findByUuid(uuid);
        } catch (Exception e) {
            log.error("Ошибка при получении документа с ID: {} для клиента с uuid: {}", uuid, e);
            throw new ServiceException("Ошибка при получении документа для клиента");
        }
    }

    //добавить документ
    @SneakyThrows
    public Documents addClientDocument(String uuid, Documents document) {
        try {
            document.setUuid(uuid);
            return documentsRepository.save(document);
        } catch (Exception e) {
            log.error("Ошибка при добавлении документа для клиента с UUID: {}", uuid, e);
            throw new ServiceException("Ошибка при добавлении документа для клиента");
        }
    }

    //обновить документ
    @SneakyThrows
    public Documents updateClientDocument(Documents document) {
        try {
            return documentsRepository.save(document);
        } catch (Exception e) {
            log.error("Ошибка при обновлении документа с UUID: {}", document.getUuid(), e);
            throw new ServiceException("Ошибка при обновлении документа");
        }
    }
//удалить документ
    @SneakyThrows
    public boolean deleteClientDocument(String uuid) {
        try {
            Optional<Documents> document = documentsRepository.findByUuid(uuid);
            if (document.isPresent()) {
                documentsRepository.delete(document.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Ошибка при удалении документа с ID: {} для клиента с UUID: {}", uuid, e);
            throw new ServiceException("Ошибка при удалении документа для клиента");
        }
    }
}
