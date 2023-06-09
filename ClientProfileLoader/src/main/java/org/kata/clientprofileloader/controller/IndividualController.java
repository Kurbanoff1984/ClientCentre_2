package org.kata.clientprofileloader.controller;

import org.kata.clientprofileloader.entity.Individual;
import org.kata.clientprofileloader.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class IndividualController {

    private final IndividualService individualService;

    @Autowired
    public IndividualController(IndividualService individualService) {
        this.individualService = individualService;
    }


    @GetMapping(value = "/individual")
    public Individual getIndividual(@RequestParam String id, @RequestParam String type) {
        return individualService.findIndividual(id, type);
    }

    @PostMapping(value = "/individual")
    public Individual setIndividual(@RequestBody Individual individual) {
        return individualService.saveIndividual(individual);
    }
}
