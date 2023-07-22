package org.kata.clientprofileloader.service;

import com.google.protobuf.ServiceException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.kata.entity.individual.Address;
import org.kata.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * этот сервис отвечает за получение, добавление, обновление и удаление адресса
 */
@Service
@AllArgsConstructor
@Slf4j
public class AddressService {
    private final AddressRepository addressRepository;
//получить адрес
    @SneakyThrows
    public Optional<Address> getClientAddress(String uuid) {
        try {
            return addressRepository.getAddressByUuid(uuid);
        } catch (Exception e) {
            log.error("Ошибка при получении адреса для клиента с UUID: {}",uuid);
            throw new ServiceException("Ошибка при получении адреса для клиента");
        }
    }
    //добавить адрес
    @SneakyThrows
    public Address addClientAddress(String uuid, Address address) {
        try {
            address.setUuid(uuid);
            return addressRepository.save(address);
        } catch (Exception e) {
            log.error("Ошибка при добавлении адреса для клиента с ID: {}", uuid, e);
            throw new ServiceException("Ошибка при добавлении адреса для клиента");
        }
    }
    //обновить адрес
    @SneakyThrows
    public Address updateClientAddress(Address address) {
        try {
            return addressRepository.save(address);
        } catch (Exception e) {
            log.error("Ошибка при обновлении адреса с ID: {}", address.getUuid(), e);
            throw new ServiceException("Ошибка при обновлении адреса");
        }
    }
    //удалить адрес
    @SneakyThrows
    public boolean deleteClientAddress(String uuid) {
        try {
            Optional<Address> address = addressRepository.getAddressByUuid(uuid);
            if (address.isPresent()) {
                addressRepository.delete(address.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error("Ошибка при удалении адреса для клиента с ID: {}", uuid, e);
            throw new ServiceException("Ошибка при удалении адреса для клиента");
        }
    }
}

