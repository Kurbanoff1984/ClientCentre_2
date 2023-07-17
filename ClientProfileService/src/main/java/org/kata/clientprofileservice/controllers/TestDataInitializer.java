package org.kata.clientprofileservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.kata.clientprofileservice.service.TestDataIndividualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testData")
@AllArgsConstructor
public class TestDataInitializer {
    private final TestDataIndividualService dataIndividual;

    @Operation(summary = "Creates the number of individuals passed in the url parameters. " +
            "Passes a message about successful creation of data to the TestUser topic.", tags = "Test data")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful creation of test data",
                    content = @Content(mediaType = "text/plain",
                                       examples = @ExampleObject(value = "Successful creation of test data, count objects: 3"))
            )
    })
    @GetMapping("/get")
    public ResponseEntity<String> getTestDataIndividual(@RequestParam(value = "count", defaultValue = "1") int count) {
        dataIndividual.createIndividuals(count);
        return ResponseEntity.ok("Successful creation of test data, count objects: " + count);
    }


}

