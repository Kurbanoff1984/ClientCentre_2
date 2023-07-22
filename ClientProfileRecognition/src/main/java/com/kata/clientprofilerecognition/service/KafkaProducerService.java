package com.kata.clientprofilerecognition.service;

import org.kata.dto.response.IndividualResponseDto;
import org.springframework.stereotype.Service;


public interface KafkaProducerService {

    void sendMessage (IndividualResponseDto individualResponseDto);

}
