package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
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
     * находит пользователя по icp или uuid
     * @param id
     * @param type
     * @return
     */
    @Override
    public IndividualResponseDto findIndividual(String id, String type)  {
        if (type.equals("UUID")) {
            individualValidation.isExistIndividualByUuid(id);
            return modelMapper.map(individualRepo.findById(id).get(), IndividualResponseDto.class);
        } else if (type.equals("ICP")){
            individualValidation.isExistIndividualByIcp(id);
            return modelMapper.map(individualRepo.findIndividualByIcp(id).get(), IndividualResponseDto.class);
        } else {
            throw new IllegalArgumentException("this type of identifier does not exist");
        }
    }
}
