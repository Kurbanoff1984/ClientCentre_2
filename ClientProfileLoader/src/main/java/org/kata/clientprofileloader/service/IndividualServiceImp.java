package org.kata.clientprofileloader.service;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileloader.entity.Individual;
import org.kata.clientprofileloader.repository.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Optional.empty;

@Service
@RequiredArgsConstructor
public class IndividualServiceImp implements IndividualService{


    private final IndividualRepository individualRepository;

    @Override
    public Individual findIndividual(String id, String type) {
        return switch (type) {
            case "uuid" -> individualRepository.findById(id).orElseThrow();
            case "icp" -> individualRepository.findByIcp(id).orElseThrow();
            default -> throw new RuntimeException("Параметр type указан некорректно!");
        };
    }

    @Override
    public Individual saveIndividual(Individual individual) {
        try {
            return individualRepository.save(individual);
        } catch (Exception e) {
            throw new RuntimeException("Возникла ошибка при записи!");
        }
    }
}
