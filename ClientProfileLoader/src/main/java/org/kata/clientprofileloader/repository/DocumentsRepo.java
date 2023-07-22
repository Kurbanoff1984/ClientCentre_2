package org.kata.clientprofileloader.repository;

import org.kata.entity.document.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepo extends JpaRepository<Documents, String> {

    /**
     * Метод для получения документов по uuid пользователя
     * @param uuid
     * @return Documents
     */
    @Query("select d from Documents d where d.individual.uuid = :uuid")
    Documents getDocumentsByUuidIndividual(@Param("uuid") String uuid);
}
