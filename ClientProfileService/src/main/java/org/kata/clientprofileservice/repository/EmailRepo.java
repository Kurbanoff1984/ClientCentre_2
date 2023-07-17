package org.kata.clientprofileservice.repository;

import org.kata.entity.contactmedium.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends JpaRepository<Email, String> {
}
