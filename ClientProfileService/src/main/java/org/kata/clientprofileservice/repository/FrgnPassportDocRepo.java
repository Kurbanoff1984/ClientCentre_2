package org.kata.clientprofileservice.repository;

import org.kata.entity.document.FrgnPassportDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrgnPassportDocRepo extends JpaRepository<FrgnPassportDoc, String> {
}
