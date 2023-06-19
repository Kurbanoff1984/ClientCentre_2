package org.kata.clientprofileloader.repository;

import org.kata.entity.individual.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IndividualRepo extends JpaRepository<Individual, String> {

}
