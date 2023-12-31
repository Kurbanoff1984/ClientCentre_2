package org.kata.clientprofileloader.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileloader.service.ContactMediumService;
import org.kata.entity.contactmedium.ContactMedium;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Контакт клиента", description = "Методы для работы с контактом клиента")
@RequestMapping("/api/client/contact")
public class ContactMediumController {
    private final ContactMediumService contactMediumService;

    @Operation(summary = "Получение контакта клиента", description = "Получает контакт клиента по его UUID")
    @GetMapping("/getContact/{icp}")
    public ResponseEntity<ContactMedium> getClientContact(@PathVariable String icp) {
        log.info("Получение контакта для клиента с icp: {}", icp);
        Optional<ContactMedium> contact = contactMediumService.getClientContact(icp);
        if (contact.isPresent()) {
            log.info("Контакт найден для клиента с icp: {}", icp);
            return new ResponseEntity<>(contact.get(), HttpStatus.OK);
        } else {
            log.info("Контакт не найден для клиента с icp: {}", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Добавление контакта клиента", description = "Добавляет контакт клиента по его UUID")
    @PostMapping("/postContact/{icp}")
    public ResponseEntity<ContactMedium> addClientContact(@PathVariable String icp, @RequestBody ContactMedium contact) {
        log.info("Контакт успешно добавлен для клиента с icp: {}", icp);
        return new ResponseEntity<>(contactMediumService.addClientContact(icp, contact), HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление контакта клиента", description = "Обновление кнтакт клиента по его UUID")
    @PutMapping("/putContact/{icp}")
    public ResponseEntity<ContactMedium> updateClientContact(@PathVariable String icp, @RequestBody ContactMedium updatedContact) {
        log.info("Обновление контакта для клиента с icp: {}", icp);
        log.info("Контакт успешно обновлен для клиента с icp: {}", icp);
        return new ResponseEntity<>(contactMediumService.updateClientContact(updatedContact), HttpStatus.OK);
    }

    @Operation(summary = "Удаление контакта клиента", description = "Удаляет кнтакт клиента по его UUID")
    @DeleteMapping("/deleteContact/{icp}")
    public ResponseEntity<Void> deleteClientContact(@PathVariable String icp) {
        log.info("Удаление контакта для клиента с icp: {}", icp);
        boolean deleted = contactMediumService.deleteClientContact(icp);
        if (deleted) {
            log.info("Контакт успешно удален для клиента с icp: {}", icp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("Контакт не найден для клиента с icp: {}", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

