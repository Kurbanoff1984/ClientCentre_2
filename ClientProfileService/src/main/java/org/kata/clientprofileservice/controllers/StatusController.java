package org.kata.clientprofileservice.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {
    private final StatusVerificationService statusVerificationService;
    @Operation(summary = "Checks the status of the client and starts the update procedure, if necessary")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful user verification",
                    content = @Content(mediaType = "text/plain",
                            examples = @ExampleObject(value = "Current client status - NOT_CLIENT. " +
                                    "List of missing documents: [RF passport, INN, Phone number]"))

            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Verification of a non-existent user",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{ 'text': 'Пользователя с таким icp = 0 не существует', " +
                                    "'date': '2023-07-17 13:19:04', 'httpStatus': 'BAD_REQUEST', 'code': 400 }"))
            )
    })
    @GetMapping("/getStatus")
    public ResponseEntity<String> getStatus(@RequestParam("icp") String icp) {
        return statusVerificationService.verificationStatusForChange(icp);
    }

}

