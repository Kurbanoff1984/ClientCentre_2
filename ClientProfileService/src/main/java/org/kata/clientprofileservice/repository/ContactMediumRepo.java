package org.kata.clientprofileservice.repository;

import org.kata.entity.contactmedium.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactMediumRepo extends JpaRepository<ContactMedium, String> {
    @Query("SELECT c FROM ContactMedium c WHERE c.individual.icp = :icp")
    Optional<ContactMedium> findAllByUserIcp(@Param("icp") String icp);
}
