package org.kata.clientprofileloader.controllers;

import lombok.AllArgsConstructor;
import org.kata.clientprofileloader.service.DocumentsService;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.entity.individual.Individual;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для взаимодействия с Documents
 */
@RestController
@RequestMapping("/documents")
@AllArgsConstructor
public class DocumentsController {
    private final DocumentsService documentsService;


    @GetMapping("/{icp}")
    public ResponseEntity<DocumentsResponseDto> getDocuments(@PathVariable("icp") String icp) {
        return new ResponseEntity<>(documentsService.getDocumentsByUuidIndividual(icp), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createDocuments(@RequestBody Individual individual) {
        documentsService.createNewDocumentsForIndividual(individual);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
