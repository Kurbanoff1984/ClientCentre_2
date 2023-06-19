package com.kata.clientprofileavatar.dao;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.kata.clientprofileavatar.entity.Avatar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class AvatarDaoImp implements AvatarDao {
    @PersistenceContext
    private final EntityManager entityManager;

    @SneakyThrows
    @Transactional
    public void addAvatar(MultipartFile file) {
        Avatar avatar = Avatar.builder()
                .uuid(UUID.randomUUID().toString())
                .name(file.getOriginalFilename())
                .fileSize((int) file.getSize())
                .byteSize(file.getBytes())
                .md5(String.valueOf(Hashing.md5().hashString(file.getOriginalFilename(), Charsets.UTF_8)))
                .build();
        log.info("преобразования мультифайла прошло успешно");
        entityManager.merge(avatar);
        log.info("аватар сохранен");
    }

    @Override
    @Transactional
    public Avatar getAvatarById(Integer id) {
        log.info("id переданно для поиска по БД");
        return entityManager.find(Avatar.class, id);
    }

    @Override
    public List<Avatar> getListOfAvatars() {
        return entityManager.createQuery("select avatar from Avatar avatar", Avatar.class).getResultList();
    }

    @Override
    @Transactional
    public Avatar getUserByAvatarUUID(String uuid) {
        log.info("uuid переданно для поиска по БД");
        Query query = entityManager.createQuery("select avatar from Avatar avatar where avatar.uuid = :uuid", Avatar.class);
        query.setParameter("uuid", uuid);
        log.info("Аватар из базы получен");
        return (Avatar) query.getSingleResult();
    }
}
