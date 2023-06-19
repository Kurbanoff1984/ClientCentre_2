package com.kata.clientprofileavatar.repositor;

import com.kata.clientprofileavatar.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AvatarRepository extends JpaRepository<Avatar, Integer> {
}

