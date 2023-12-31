package org.kata.clientprofileservice.controllers;


import lombok.RequiredArgsConstructor;
import org.kata.dto.response.DocumentsResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentsController {

    private final String DOC_CONTROLLER_URL = "/documents/";

    @GetMapping("/{icp}")
    public ResponseEntity<DocumentsResponseDto> getDocumentsByIcp(@PathVariable("icp") String icp) {
        //TODO реализовать запрос через REST в LOADER используя DAO
        //DocumentsResponseDto response = restTemplateService.getEntity(DOC_CONTROLLER_URL + individualService.getIndividualUuid(icp),
        //                                DocumentsResponseDto.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{icp}")
    public ResponseEntity<Void> createDocumentsByIcp(@PathVariable("icp") String icp) {
        //restTemplateService.createEntity(DOC_CONTROLLER_URL, individualService.getClientByIcp(icp), Void.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
