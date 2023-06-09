package org.kata.clientprofileloader.repository;

import org.kata.clientprofileloader.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, String> {
    Optional<Individual> findByIcp(String id);
}

