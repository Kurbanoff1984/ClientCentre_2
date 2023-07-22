package org.kata.clientprofileloader.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.kata.clientprofileloader.service.DocumentsService;
import org.kata.clientprofileloader.service.KafkaConsumerService;
import org.kata.dto.response.DocumentsResponseDto;
import org.kata.dto.response.IndividualResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class KafkaConsumerImpl implements KafkaConsumerService {
    private final DocumentsService documentsService;
@Autowired
    public KafkaConsumerImpl(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }

    @Override
    @KafkaListener(topics = "recognition_document")
    public List<String> KafkaListener(IndividualResponseDto individualResponseDto, String icp) {
        List<String> errDto = new ArrayList<>();
        IndividualResponseDto individualResponseDto1 = individualResponseDto;
        if (individualResponseDto1.getIcp().equals(icp)) {

            //Проверка полей
            if (individualResponseDto1.getUuid().isEmpty()) {
                errDto.add("Поле Uuid не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getName().isEmpty()) {
                errDto.add("Поле Name не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getSurname().isEmpty()) {
                errDto.add("Поле Surname не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getPatronymic().isEmpty()) {
                errDto.add("Поле Patronymic не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getFullName().isEmpty()) {
                errDto.add("Поле FullName не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getGender().isEmpty()) {
                errDto.add("Поле Gender не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getPlaceOfBirth().isEmpty()) {
                errDto.add("Поле PlaceOfBirth не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getCountryOfBirth().isEmpty()) {
                errDto.add("Поле CountryOfBirth не распознано, требуется работа оператора");
            } else if (individualResponseDto1.getBirthDate()==null) {
                errDto.add("Поле Date не распознано, требуется работа оператора");
            }

            documentsService.createNewDocumentsForIndividual(individualResponseDto);



        } else {
            log.info("Пользователь не найден");
        }


        return errDto;
    }


}
