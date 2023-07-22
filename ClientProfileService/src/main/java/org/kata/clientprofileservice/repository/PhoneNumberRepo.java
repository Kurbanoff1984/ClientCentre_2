package org.kata.clientprofileservice.repository;

import org.kata.entity.contactmedium.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, String> {
}
