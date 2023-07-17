package com.kata.clientprofilefacade.controller;

import com.kata.clientprofilefacade.service.GetDocumentsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * This is a controller class that allows you to get a document by a token.
 * 1) if not a token - information about the presence of the document
 * 2) if Bearer token is a masked document
 * 3) if JWT Bearer token is an unmasked document
 * 4) if the token is invalid - an error
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Tag(name = "Controller to get the document depending on the token")
public class DocumentsController {

    private final GetDocumentsService getDocumentsService;

    /**
     * The method allows you to get the document depending on the token
     */
    @GetMapping("/documents/{uuidInd}")
    public <T> ResponseEntity<T> getDocuments(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("uuidInd") String uuid) {
        return getDocumentsService.giveDocuments(token, uuid);
    }




}
