package org.kata.clientprofileloader.service;

import com.google.protobuf.ServiceException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.kata.entity.contactmedium.ContactMedium;
import org.kata.repository.ContactMediumRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Этот сервис отвечает за выполнение операций получения, добавления, обновления и
 * удаления контактной информации клиента
 */
@Service
@AllArgsConstructor
@Slf4j
public class ContactMediumService {
    private final ContactMediumRepository contactMediumRepository;

    // Возвращает контактную информацию клиента по указанному UUID
    @SneakyThrows
    public Optional<ContactMedium> getClientContact(String uuid) {
        try {
            return contactMediumRepository.getContactMediumByUuid(uuid);
        } catch (Exception e) {
            log.error("Ошибка при получении контакта для клиента с UUID: {}", uuid, e);
            throw new ServiceException("Ошибка при получении контакта для клиента");
        }
    }

    //Добавляет контактную информацию клиента по указанному UUID
    @SneakyThrows
    public ContactMedium addClientContact(String uuid, ContactMedium contactMedium) {
        try {
            contactMedium.setUuid(uuid);
            return contactMediumRepository.save(contactMedium);
        } catch (Exception e) {
            log.error("Ошибка при добавлении контакта для клиента с UUID: {}", uuid, e);
            throw new ServiceException("Ошибка при добавлении контакта для клиента");

        }
    }

    //Обновлят  контактную информацию клиента по указанному UUID
    @SneakyThrows
    public ContactMedium updateClientContact(ContactMedium contactMedium) {
        try {
            return contactMediumRepository.save(contactMedium);
        } catch (Exception e) {
            log.error("Ошибка при обновлении контакта для клиента с UUID: {}", contactMedium.getUuid(), e);
            throw new ServiceException("Ошибка при обновлении контакта для клиента");
        }
    }

    //Удаляет контактную информацию клиента по указанному UUID
    @SneakyThrows
    public boolean deleteClientContact(String uuid) {
        try {
            Optional<ContactMedium> contact = contactMediumRepository.getContactMediumByUuid(uuid);
            if (contact.isPresent()) {
                contactMediumRepository.delete(contact.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Ошибка при удалении контакта для клиента с UUID: {}", uuid, e);
            throw new ServiceException("Ошибка при удалении контакта для клиента");
        }
    }
}
