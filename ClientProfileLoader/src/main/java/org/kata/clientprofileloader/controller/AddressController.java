package org.kata.clientprofileloader.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileloader.service.AddressService;
import org.kata.entity.individual.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Адреса клиентов", description = "Методы для работы с адресами клиентов")
@RequestMapping("/api/client/{uuid}/address")
public class AddressController {
    private final AddressService addressService;

    @Operation(summary = "Получение адреса клиента", description = "Получает адрес клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Адрес успешно получен", response = Address.class),
            @ApiResponse(code = 404, message = "Адрес не найден")})
    @GetMapping
    public ResponseEntity<Address> getClientAddress(@PathVariable String uuid) {
        log.info("Получение адреса для клиента с ID: {}", uuid);
        Optional<Address> address = addressService.getClientAddress(uuid);
        if (address.isPresent()) {
            log.info("Адрес найден для клиента с ID: {}", uuid);
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        } else {
            log.info("Адрес не найден для клиента с ID: {}", uuid);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = "Добавление адреса клиента", description = "Добавляет адрес для клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Адрес успешно добавлен", response = Address.class)
    })
    @PostMapping
    public ResponseEntity<Address> addClientAddress(@PathVariable String uuid, @RequestBody Address address) {
        log.info("Адрес успешно добавлен для клиента с ID: {}", uuid);
        return new ResponseEntity<>(addressService.addClientAddress(uuid, address), HttpStatus.CREATED);
    }
    @Operation(summary = "Обновление адреса клиента", description = "Обновляет адрес клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Адрес успешно обновлен", response = Address.class)
    })
    @PutMapping
    public ResponseEntity<Address> updateClientAddress(@PathVariable String uuid, @RequestBody Address updatedAddress) {
        log.info("Обновление адреса для клиента с ID: {}", uuid);
        Address address = new Address();;
        log.info("Адрес успешно обновлен для клиента с ID: {}", uuid);
        return new ResponseEntity<>(addressService.updateClientAddress(address), HttpStatus.OK);
    }
    @Operation(summary = "Удаление адреса клиента", description = "Удаляет адрес клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Адрес успешно удален"),
            @ApiResponse(code = 404, message = "Адрес не найден")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteClientAddress(@PathVariable String uuid) {
        log.info("Удаление адреса для клиента с ID: {}", uuid);
        if (addressService.deleteClientAddress(uuid)) {
            log.info("Адрес успешно удален для клиента с ID: {}", uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("Адрес не найден для клиента с ID: {}", uuid);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
