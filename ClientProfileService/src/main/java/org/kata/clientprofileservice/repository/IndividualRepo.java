package org.kata.clientprofileservice.repository;

import org.kata.clientprofileservice.service.projection.IndividualUuidProjection;
import org.kata.entity.individual.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IndividualRepo extends JpaRepository<Individual, String> {

    Optional<Individual> findIndividualByUuid(String uuid);
    Optional<Individual> findIndividualByIcp(String icp);

    List<IndividualUuidProjection> findUuidByIcp(String icp);

    @Query("select count(i) > 0 from Individual i where i.icp = :icp")
    boolean existByIcp(@Param("icp") String icp);


}
