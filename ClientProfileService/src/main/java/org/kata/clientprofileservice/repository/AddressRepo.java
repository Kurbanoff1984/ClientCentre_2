package org.kata.clientprofileservice.repository;

import org.kata.entity.individual.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, String> {
}
