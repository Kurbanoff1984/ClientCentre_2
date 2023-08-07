package org.kata.clientprofileloader.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileloader.service.DocumentService;
import org.kata.entity.document.Documents;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@Tag(name = "Документы клиента", description = "Методы для работы с документами клиента")
@RequestMapping("/api/client/documents")
public class DocumentController {

    private final DocumentService documentService;

    @Operation(summary = "Получение списка документов клиента", description = "Получает список документов клиента по его icp")
    @GetMapping("getAllDocuments/{icp}")
    public ResponseEntity<List<Documents>> getClientDocuments(@PathVariable String icp) {
        log.info("Получение списка документов для клиента с icp: {}", icp);
        List<Documents> documents = documentService.getClientDocuments(icp);
        log.info("Найдено {} документов для клиента с icp: {}", documents.size(), icp);
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @Operation(summary = "Получает документ клиента", description = "Получает  документ клиента по его icp")
    @GetMapping("getDocument/{icp}")
    public ResponseEntity<Documents> getClientDocument(@PathVariable String icp) {
        log.info("Получение документа с icp: {}", icp);
        Optional<Documents> document = documentService.getClientDocument(icp);
        if (document.isPresent()) {
            log.info("Документ с icp: {} ", icp);
            return new ResponseEntity<>(document.get(), HttpStatus.OK);
        } else {
            log.info("Документ с icp: {} не найден для клиента", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Добавить документ клиента", description = "Добавляет  документ клиента по его icp")
    @PostMapping("/postDocument/{icp}")
    //DocumentDto
    public ResponseEntity<Documents> addClientDocument(@PathVariable String icp, @RequestBody Documents document) {
        log.info("Документ успешно добавлен для клиента с icp: {}", icp);
        return new ResponseEntity<>(documentService.addClientDocument(icp, document), HttpStatus.CREATED);
    }

    @Operation(summary = "Обновляет документ клиента", description = "Обновлеят  документ клиента по его icp")
    @PutMapping("/putDocument/{icp}")
    public ResponseEntity<Documents> updateClientDocument(@PathVariable String icp) {
        log.info("Обновление документа с icp: {} для клиента", icp);
        Documents document = new Documents();
        log.info("Документ успешно обновлен с icp: {} для клиента ", icp);
        return new ResponseEntity<>(documentService.updateClientDocument(document), HttpStatus.OK);
    }

    @Operation(summary = "Удаляет документ клиента", description = "Удаляет  документ клиента по его icp")
    @DeleteMapping("/deleteDocument/{icp}")
    public ResponseEntity<Documents> deleteClientDocument(@PathVariable String icp) {
        log.info("Удаление документа с icp: {} для клиента ", icp);
        boolean deleted = documentService.deleteClientDocument(icp);
        if (deleted) {
            log.info("Документ успешно удален с ID: {} для клиента ", icp);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            log.info("Документ с ID: {} не найден для клиента ", icp);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}




