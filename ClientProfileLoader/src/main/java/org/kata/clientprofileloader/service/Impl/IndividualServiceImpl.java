package org.kata.clientprofileloader.service.Impl;

import lombok.AllArgsConstructor;
import org.kata.clientprofileloader.repository.IndividualRepo;
import org.kata.clientprofileloader.service.IndividualService;
import org.kata.entity.individual.Individual;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndividualServiceImpl implements IndividualService {

    private final IndividualRepo individualRepo;
    @Override
    public Individual getClient(String uuid) {
        return individualRepo.findById(uuid).orElse(null);
    }
}
