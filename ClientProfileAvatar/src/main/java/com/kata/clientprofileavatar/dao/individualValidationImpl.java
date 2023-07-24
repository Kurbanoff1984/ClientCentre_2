package com.kata.clientprofileavatar.dao;



import com.kata.clientprofileavatar.entity.entityAvatar.Individual;
import com.kata.clientprofileavatar.repository.IndividualRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.kata.exception.NotFoundEntityException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
@Slf4j
public class individualValidationImpl implements individualValidation {

    private final IndividualRepository individualRepository;

    @Override
    public void isExistIndividualByIcp(String profileIdentification) {
        if (!isNull(profileIdentification)) {
            log.debug("Проверка запуска существует ли ползавватель перед выполнением операции с icp = {}", profileIdentification);

            if (!individualRepository.existByIcp(profileIdentification)) {
                log.error("пользователь с icp = {} не найден", profileIdentification);
                throw new NotFoundEntityException(String.format("Пользователя с таким icp = %s не существует", profileIdentification));
            }
            log.info("пользователь icp = {} найден", profileIdentification);
        }
    }
    @Override
    public Optional<Individual> getClientByIcp(String profileIdentification) {
        individualRepository.existByIcp(profileIdentification);
        return individualRepository.findIndividualByIcp(profileIdentification);
    }
/*    @Override
    @Transactional
    public Avatar getClientByIcp(String profileIdentification) {
        blackListDao.checkOfNullEndLimitedID(uuid, "uuid");
        log.info("uuid переданно для поиска по БД");
        Query query = entityManager.createQuery("select avatar from Avatar avatar where avatar.uuid = :uuid", Avatar.class);
        query.setParameter("uuid", uuid);
        log.info("Аватар из базы получен");
        return (Avatar) query.getSingleResult();
    }*/
}
