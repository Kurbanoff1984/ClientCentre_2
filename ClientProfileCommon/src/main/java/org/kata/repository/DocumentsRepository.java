package org.kata.repository;

import org.kata.entity.document.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DocumentsRepository extends JpaRepository<Documents,String> {
List<Documents> findAllByUuid (String uuid);
Optional<Documents> findByUuid (String uuid);
}
