package org.kata.clientprofileservice.repository;

import org.kata.entity.individual.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepo extends JpaRepository<Address, String> {
    @Query("SELECT a FROM Address a WHERE a.individual.icp = :icp")
    Optional<Address> findByUserIcp(@Param("icp") String icp);
}
