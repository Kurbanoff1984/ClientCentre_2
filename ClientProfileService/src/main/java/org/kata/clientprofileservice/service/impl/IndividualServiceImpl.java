package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.util.statusDto.IndividualStatusDto;
import org.kata.clientprofileservice.repository.IndividualRepo;
import org.kata.clientprofileservice.service.IndividualService;

import org.kata.clientprofileservice.service.projection.IndividualUuidProjection;
import org.kata.clientprofileservice.validation.databaseValidation.IndividualValidation;
import org.kata.clientprofileservice.validation.fieldEntityValidation.validationDto.IndividualValidationDto;
import org.kata.dto.response.IndividualResponseDto;
import org.kata.entity.individual.Individual;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * класс для бизнес-логики с Individual
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IndividualServiceImpl implements IndividualService {
    private final IndividualRepo individualRepo;

    private final IndividualValidation individualValidation;

    private final ModelMapper modelMapper;


    @Override
    public void save(Individual individual) {
        individualRepo.save(individual);
    }

    @Override
    @Transactional
    public void createClient(IndividualValidationDto dto) {
        individualRepo.save(modelMapper.map(dto, Individual.class));
    }

    @Override
    public Individual getClientByIcp(String icp) {
        individualValidation.isExistIndividualByIcp(icp);
        return individualRepo.findIndividualByIcp(icp).get();
    }


    /**
     * Метод для получения uuid пользователя по его icp
     * @param icp
     * @return String
     */
    @Override
    public String getIndividualUuid(String icp) {
        String uuid = individualRepo.findUuidByIcp(icp).stream()
                .map(IndividualUuidProjection::getUuid)
                .findFirst()
                .orElse(null);
        return uuid;
    }

    /**
     * Находит пользователя по icp и конвертирует в формат IndividualStatusDto для проверки статуса
     * @param id - значение уникального идентификатора пользователя (UUID, ICP)
     * @param type - тип уникального идентификатора (UUID, ICP)
     * @return IndividualStatusDto
     */
    @Override
    public IndividualStatusDto findIndividualForVerificationStatus(String id, String type) {
        if (type.equals("UUID")) {
            individualValidation.isExistIndividualByUuid(id);
            return modelMapper.map(individualRepo.findById(id).get(), IndividualStatusDto.class);
        } else if (type.equals("ICP")){
            individualValidation.isExistIndividualByIcp(id);
            return modelMapper.map(individualRepo.findIndividualByIcp(id).get(), IndividualStatusDto.class);
        } else {
            throw new IllegalArgumentException("this type of identifier does not exist");
        }
    }
}
