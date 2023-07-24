package com.kata.clientprofileavatar.dao;

import com.kata.clientprofileavatar.entity.entityAvatar.Individual;

import java.util.Optional;

public interface individualValidation {
    void isExistIndividualByIcp(String profileIdentification);
    Optional<Individual> getClientByIcp(String profileIdentification);
}
