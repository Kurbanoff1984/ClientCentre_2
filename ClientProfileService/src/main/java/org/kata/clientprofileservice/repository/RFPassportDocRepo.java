package org.kata.clientprofileservice.repository;

import org.kata.entity.document.RFPassportDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFPassportDocRepo extends JpaRepository<RFPassportDoc, String> {
}
