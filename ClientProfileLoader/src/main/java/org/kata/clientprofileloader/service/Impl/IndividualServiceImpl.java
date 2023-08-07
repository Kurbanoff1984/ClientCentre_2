package org.kata.clientprofileloader.service.Impl;

import lombok.AllArgsConstructor;
import org.kata.entity.individual.Individual;
import org.kata.repository.IndividualRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualServiceImpl {

    private final IndividualRepository individualRepo;

    public Individual getClient(String uuid) {
        return individualRepo.findById(uuid).orElse(null);
    }

    public Individual findIndividual(String id, String type) {
        //TODO Реализовать метод
        return null;
    }

    public Individual saveIndividual(Individual individual) {
        //TODO Реализовать метод
        return null;
    }
}
