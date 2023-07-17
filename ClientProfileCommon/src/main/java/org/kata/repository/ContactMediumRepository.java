package org.kata.repository;

import org.kata.entity.contactmedium.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactMediumRepository extends JpaRepository<ContactMedium, String> {
    Optional<ContactMedium> getContactMediumByUuid(String uuid);
}
