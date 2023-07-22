package org.kata.clientprofileservice.repository;

import org.kata.entity.document.SNILSDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnilsDocRepo extends JpaRepository<SNILSDoc, String> {
}
