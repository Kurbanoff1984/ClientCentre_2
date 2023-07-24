package com.kata.clientprofileavatar.repository;



import com.kata.clientprofileavatar.entity.entityAvatar.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IndividualRepository extends JpaRepository<Individual, Integer> {
    Optional<Individual> findIndividualByIcp(String icp);
    @Query("select count(i) > 0 from Individual i where i.icp = :icp")
    boolean existByIcp(@Param("icp") String icp);
}
