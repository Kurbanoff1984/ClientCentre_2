package org.kata.clientprofileservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.kata.clientprofileservice.service.IndividualService;
import org.kata.clientprofileservice.service.StatusVerificationService;
import org.kata.clientprofileservice.util.statusDto.IndividualStatusDto;
import org.kata.entity.individual.Individual;
import org.kata.enums.IndividualStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.kata.enums.IndividualStatus.*;
import static org.kata.enums.IndividualStatus.CLIENT;

/**
 * Класс для анализа статуса пользователя и запуска его смены при необходимости
 */
@Service
@RequiredArgsConstructor
public class StatusVerificationServiceImpl implements StatusVerificationService {
    private final IndividualService individualService;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "UPDATE_STATUS";

    /**
     * Предварительная проверка на необходимость смены статуса пользователя (статус отличный от CLIENT;
     * дата dateStatus - не равно null, говорит о том что пользователь еще не проходил процедуру верификации статуса;
     * разница между последней и текущей верификациями не меньше часа)
     * @param icp - уникальный идентификатор пользователя
     * @return - список недостающих документов для статуса CLIENT
     */
    @Override
    public ResponseEntity<String> verificationStatusForChange(String icp) {

        IndividualStatusDto dto = individualService.findIndividualForVerificationStatus(icp, "ICP");

        if (dto.getStatus() == CLIENT) {
            return ResponseEntity.ok().body( "All necessary documents are present. The individual is a client.");
        }
        if (dto.getDateStatus() != null) {
            long differenceInTime = dto.getDateStatus().until(LocalDateTime.now(), ChronoUnit.HOURS);
            if (differenceInTime <= 1) {
                return ResponseEntity.ok().body("The current status of the individual is a " +
                        dto.getStatus() + " , verification is not required.");
            } else {
                return verificationStatus(dto, icp);
            }
        } else {
            return verificationStatus(dto, icp);
        }
    }

    /**
     * Инициация проверки недостающих документов для пользователей прошедших предварительную проверку на необходимость смены статуса,
     * после формирования списка недостающих документов - статус и icp отправляются в кафку для передачи в ProfileUpdate
     * @param dto - информация пользователя
     * @param icp - уникальный идентификатор пользователя
     * @return - список недостающих документов
     */
    protected ResponseEntity<String> verificationStatus(IndividualStatusDto dto, String icp) {
        Map<IndividualStatus, List<String>> map = getRequiredDocumentsAndStatus(dto);

        Individual individual = individualService.getClientByIcp(icp);
        individual.setDateStatus(LocalDateTime.now());
        individualService.save(individual);

        if (map.containsKey(dto.getStatus())) {
            return ResponseEntity.ok().body("Current client status - " + dto.getStatus() +
                    ". List of missing documents: " + map.get(dto.getStatus()));
        } else {
            IndividualStatus individualStatusForUpdate = map.entrySet().stream().findFirst().map(Map.Entry::getKey).orElse(null);
            kafkaTemplate.send(TOPIC, individualStatusForUpdate + " " + icp);
            return ResponseEntity.ok().body("There is a procedure for updating the status on the " + individualStatusForUpdate +
                    ". List of missing documents: " + map.get(individualStatusForUpdate));
        }
    }

    /**
     *
     * @param dto - информация о пользователе
     * @return - HashMap: значение - список не достающих документов до статуса CLIENT, ключ - статус, соответствующий
     * данному списку недостающих документов
     */
    protected Map<IndividualStatus, List<String>> getRequiredDocumentsAndStatus(IndividualStatusDto dto) {
        List<String> requiredDocuments = new ArrayList<>();
        if (dto.getStatus() != CLIENT) {
            if (dto.getDocuments() != null) {
                if (dto.getDocuments().getRfPassportDocs().isEmpty()) {
                    requiredDocuments.add("RF passport");
                }
                if (dto.getDocuments().getSnilsDoc() == null) {
                    requiredDocuments.add("Snils");
                }
                if (dto.getDocuments().getInnDoc() == null) {
                    requiredDocuments.add("INN");
                }
            } else {
                requiredDocuments.add("RF passport");
                requiredDocuments.add("Snils");
                requiredDocuments.add("INN");
            }
            if (dto.getAddress() == null) {
                requiredDocuments.add("Address");
            }
            if (dto.getContacts() != null) {
                if (dto.getContacts().getPhoneNumbers().isEmpty()) {
                    requiredDocuments.add("Phone number");
                }
            } else {
                requiredDocuments.add("Phone number");
            }
        }
        Map<IndividualStatus, List<String>> map = new HashMap<>();
        if (!requiredDocuments.isEmpty()) {
            if (requiredDocuments.size() != 5 && !requiredDocuments.contains("RF passport")) {
                map.put(PROSPECT, requiredDocuments);
            } else {
                map.put(NOT_CLIENT, requiredDocuments);
            }
        } else {
            map.put(CLIENT, requiredDocuments);
        }
        return map;
    }

}
