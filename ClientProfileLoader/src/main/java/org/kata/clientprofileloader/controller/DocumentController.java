package org.kata.clientprofileloader.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.entity.document.Documents;
import org.kata.entity.individual.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.kata.clientprofileloader.service.DocumentService;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Документы клиента", description = "Методы для работы с документами клиента")
@RequestMapping("/api/client/{uuid}/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Operation(summary = "Получение списка документов клиента", description = "Получает список документов клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Список успешно получен", response = Address.class),
            @ApiResponse(code = 404, message = "Список не найден")})
    @GetMapping
    public ResponseEntity<List<Documents>> getClientDocuments(@PathVariable String uuid) {
        log.info("Получение списка документов для клиента с UUID: {}", uuid);
        List<Documents> documents = documentService.getClientDocuments(uuid);
        log.info("Найдено {} документов для клиента с UUID: {}", documents.size(), uuid);
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @Operation(summary = "Получает документ клиента", description = "Получает  документ клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Документ успешно получен", response = Address.class),
            @ApiResponse(code = 404, message = "Документ не найден")})
    @GetMapping("/{uuid}")
    public ResponseEntity<Documents> getClientDocument(@PathVariable String uuid) {
        log.info("Получение документа с UUID: {}", uuid);
        Optional<Documents> document = documentService.getClientDocument(uuid);
        if (document.isPresent()) {
            log.info("Документ с UUID: {} ", uuid);
            return new ResponseEntity<>(document.get(), HttpStatus.OK);
        } else {
            log.info("Документ с UUID: {} не найден для клиента", uuid);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Добавить документ клиента", description = "Добавляет  документ клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Документ успешно добавлен", response = Address.class),
            @ApiResponse(code = 404, message = "Документ не добавлен")})
    @PostMapping
    public ResponseEntity<Documents> addClientDocument(@PathVariable String uuid, @RequestBody Documents document) {
        log.info("Документ успешно добавлен для клиента с ID: {}", uuid);
        return new ResponseEntity<>(documentService.addClientDocument(uuid, document), HttpStatus.CREATED);
    }

    @Operation(summary = "Обновляет документ клиента", description = "Обновлеят  документ клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Документ успешно обновлен", response = Address.class),
            @ApiResponse(code = 404, message = "Документ не обновлен")})
    @PutMapping("/{uuid}")
    public ResponseEntity<Documents> updateClientDocument(@PathVariable String uuid) {
        log.info("Обновление документа с UUID: {} для клиента", uuid);
        Documents document = new Documents();
        log.info("Документ успешно обновлен с UUID: {} для клиента ", uuid);
        return new ResponseEntity<>(documentService.updateClientDocument(document), HttpStatus.OK);
    }

    @Operation(summary = "Удаляет документ клиента", description = "Удаляет  документ клиента по его UUID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Документ успешно удален", response = Address.class),
            @ApiResponse(code = 404, message = "Документ не удален")})
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteClientDocument(@PathVariable String uuid) {
        log.info("Удаление документа с UUID: {} для клиента ", uuid);
        boolean deleted = documentService.deleteClientDocument(uuid);
        if (deleted) {
            log.info("Документ успешно удален с ID: {} для клиента ", uuid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("Документ с ID: {} не найден для клиента ", uuid);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}




