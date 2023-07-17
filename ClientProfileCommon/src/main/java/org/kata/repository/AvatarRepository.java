package org.kata.repository;

import org.kata.entity.individual.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, String> {
    Optional<Avatar> getAvatarByUuid(String uuid);
}
