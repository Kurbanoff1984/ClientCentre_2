package org.kata.clientprofileservice.validation.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.kata.clientprofileservice.repository.IndividualRepo;
import org.kata.clientprofileservice.validation.IndividualValidation;

import org.kata.exception.NotFoundEntityException;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

/**
 * Класс валидации для Individual, внедряется в IndividualServiceImpl
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class IndividualValidationImpl implements IndividualValidation {

    private final IndividualRepo individualRepo;

    /**
     * Метод проверки существования пользователя в БД по его icp
     * @param icp
     */
    @Override
    public void isExistIndividualByIcp(String icp) {
        if (!isNull(icp)) {
            log.debug("Start validation is exist individual before performing an operation with icp = {}", icp);

            if (!individualRepo.existByIcp(icp)) {
                log.error("Individual with icp = {} is not exist", icp);
                throw new NotFoundEntityException(String.format("Пользователя с таким icp = %s не существует", icp));
            }
            log.info("Success validation is exist individual with icp = {}", icp);
        }
    }

    @Override
    public void isExistIndividualByUuid(String uuid) {
        if (!isNull(uuid)) {
            log.debug("Start validation is exist individual before performing an operation with uuid = {}", uuid);

            if (!individualRepo.existsById(uuid)) {
                log.error("Individual with uuid = {} is not exist", uuid);
                throw new NotFoundEntityException(String.format("Пользователя с таким uuid = %s не существует", uuid));
            }
            log.info("Success validation is exist individual with uuid = {}", uuid);
        }
    }
}
