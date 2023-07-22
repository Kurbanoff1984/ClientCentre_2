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
@RequestMapping("/api/client/address")
public class AddressController {
    private final AddressService addressService;

    @Operation(summary = "Получение адреса клиента", description = "Получает адрес клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Адрес успешно получен", response = Address.class),
            @ApiResponse(code = 404, message = "Адрес не найден")})
    @GetMapping("/getAddress/{icp}")
    public ResponseEntity<Address> getClientAddress(@PathVariable String icp) {
        log.info("Получение адреса для клиента с icp: {}", icp);
        Optional<Address> address = addressService.getClientAddress(icp);
        if (address.isPresent()) {
            log.info("Адрес найден для клиента с icp: {}", icp);
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        } else {
            log.info("Адрес не найден для клиента с icp: {}", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Operation(summary = "Добавление адреса клиента", description = "Добавляет адрес для клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Адрес успешно добавлен", response = Address.class)
    })
    @PostMapping("/postAddress/{icp}")
    public ResponseEntity<Address> addClientAddress(@PathVariable String icp, @RequestBody Address address) {
        log.info("Адрес успешно добавлен для клиента с icp: {}", icp);
        return new ResponseEntity<>(addressService.addClientAddress(icp, address), HttpStatus.CREATED);
    }
    @Operation(summary = "Обновление адреса клиента", description = "Обновляет адрес клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Адрес успешно обновлен", response = Address.class)
    })
    @PutMapping("/putAdress/{icp}")
    public ResponseEntity<Address> updateClientAddress(@PathVariable String icp, @RequestBody Address updatedAddress) {
        log.info("Обновление адреса для клиента с icp: {}", icp);
        log.info("Адрес успешно обновлен для клиента с icp: {}", icp);
        return new ResponseEntity<>(addressService.updateClientAddress(updatedAddress), HttpStatus.OK);
    }
    @Operation(summary = "Удаление адреса клиента", description = "Удаляет адрес клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Адрес успешно удален"),
            @ApiResponse(code = 404, message = "Адрес не найден")
    })
    @DeleteMapping("/deleteAddress/{icp}")
    public ResponseEntity<Void> deleteClientAddress(@PathVariable String icp) {
        log.info("Удаление адреса для клиента с icp: {}", icp);
        if (addressService.deleteClientAddress(icp)) {
            log.info("Адрес успешно удален для клиента с ID: {}", icp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("Адрес не найден для клиента с ID: {}", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
