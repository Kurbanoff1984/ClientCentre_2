package com.kata.clientprofileavatar.repository;

import com.kata.clientprofileavatar.entity.entityKafcka.IspStatysOrderKafkaOrderOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessegAvatarStatysRepository extends JpaRepository<IspStatysOrderKafkaOrderOne, Integer> {
}
