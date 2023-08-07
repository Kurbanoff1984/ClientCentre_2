package org.kata.clientprofileloader.controller;

import lombok.RequiredArgsConstructor;
import org.kata.entity.individual.Individual;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class IndividualController {

    @GetMapping(value = "/individual")
    public Individual getIndividual(@RequestParam String id, @RequestParam String type) {
        //TODO запрос в БД по ключу или icp или uuid реализовать
        return null;
    }

    @PostMapping(value = "/individual")
    public Individual setIndividual(@RequestBody Individual individual) {
        //TODO запрос в БД создание пользователя
        return null;
    }
}
