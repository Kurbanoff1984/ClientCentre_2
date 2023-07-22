package org.kata.clientprofileloader.service;

import com.google.protobuf.ServiceException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.kata.entity.individual.Avatar;
import org.kata.repository.AvatarRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Этот сервис отвечает за получение, добавление, обновление и удаление аватара
 */
@Service
@AllArgsConstructor
@Slf4j
public class AvatarService {
    private final AvatarRepository avatarRepository;

    //получить аватар
    @SneakyThrows
    public Optional<Avatar> getClientAvatar(String uuid) {
        try {
            return avatarRepository.getAvatarByUuid(uuid);
        } catch (Exception e) {
            log.error("Ошибка при получении аватара для клиента с UUID: {}", uuid, e);
            throw new ServiceException("Ошибка при получении аватара для клиента");
        }
    }

    //добавить аватар
    @SneakyThrows
    public Avatar addClientAvatar(String uuid, Avatar avatar) {
        try {
            avatar.setUuid(uuid);
            return avatarRepository.save(avatar);
        } catch (Exception e) {
            log.error("Ошибка при добавлении аватара для клиента с ID: {}", uuid, e);
            throw new ServiceException("Ошибка при добавлении аватара для клиента");
        }
    }

    // обновление аватара
    @SneakyThrows
    public Avatar updateClientAvatar(Avatar avatar) {
        try {
            return avatarRepository.save(avatar);
        } catch (Exception e) {
            log.error("Ошибка при обновлении аватара с UUID: {}", avatar.getUuid(), e);
            throw new ServiceException("Ошибка при обновлении аватара");
        }
    }

    //удаление аватара
    @SneakyThrows
    public boolean deleteClientAvatar(String uuid) {
        try {
            Optional<Avatar> avatar = avatarRepository.getAvatarByUuid(uuid);
            if (avatar.isPresent()) {
                avatarRepository.delete(avatar.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Ошибка при удалении аватара для клиента с ID: {}", uuid, e);
            throw new ServiceException("Ошибка при удалении аватара для клиента");
        }
    }
}





