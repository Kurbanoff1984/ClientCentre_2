package org.kata.clientprofileservice.repository;

import org.kata.entity.document.INNDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INNDocRepo extends JpaRepository<INNDoc, String> {
}
