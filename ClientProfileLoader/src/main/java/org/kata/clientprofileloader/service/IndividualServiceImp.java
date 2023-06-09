package org.kata.clientprofileloader.service;

import org.kata.clientprofileloader.entity.Individual;
import org.kata.clientprofileloader.repository.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Optional.empty;

@Service
public class IndividualServiceImp implements IndividualService{


    private final IndividualRepository individualRepository;

    @Autowired
    public IndividualServiceImp(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    @Override
    public Individual findIndividual(String id, String type) {
        return type.equals("uuid") == true ? individualRepository.findById(id).orElseThrow() :
                type.equals("icp") == true ? individualRepository.findByIcp(id).orElseThrow() : Optional.of(new Individual()).orElseThrow();
    }

    @Override
    public Individual saveIndividual(Individual individual) {
        return individualRepository.save(individual);
    }
}
