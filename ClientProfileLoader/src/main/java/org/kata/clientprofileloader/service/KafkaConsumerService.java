package org.kata.clientprofileloader.service;

import org.kata.dto.response.IndividualResponseDto;

import java.util.List;

public interface KafkaConsumerService {
    List<String> KafkaListener(IndividualResponseDto individualResponseDto, String icp);
}
