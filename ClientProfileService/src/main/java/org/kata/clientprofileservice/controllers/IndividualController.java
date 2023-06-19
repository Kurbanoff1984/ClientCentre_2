package org.kata.clientprofileservice.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileservice.service.impl.IndividualServiceImpl;
import org.kata.dto.response.IndividualResponseDto;
import org.kata.entity.individual.Individual;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/individual")
@RequiredArgsConstructor
public class IndividualController {

    private final IndividualServiceImpl individualService;


    @PostMapping("/createClient")
    public ResponseEntity<Void> createClient(@RequestBody Individual individual) {
        individualService.createClient(individual);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/getClient")
    public ResponseEntity<IndividualResponseDto> getClient(@RequestParam("id") String id,
                                                           @RequestParam(value = "type", defaultValue = "ICP") String type) {
        return new ResponseEntity<>(individualService.findIndividual(id, type), HttpStatus.OK);
    }


}
