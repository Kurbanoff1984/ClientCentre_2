package com.kata.clientprofilerecognition.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.kata.dto.response.IndividualResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
@Slf4j
public class KafkaProducerImpl implements KafkaProducerService {

    private final static String TOPIC_NAME = "recognition_document";

    KafkaTemplate<String, IndividualResponseDto> kafkaTemplate;

    @Autowired
    public KafkaProducerImpl(KafkaTemplate<String, IndividualResponseDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(IndividualResponseDto individualResponseDto) {
        ListenableFuture<SendResult<String, IndividualResponseDto>> future = (ListenableFuture<SendResult<String, IndividualResponseDto>>) kafkaTemplate.send(new ProducerRecord<>(TOPIC_NAME, individualResponseDto));
        future.addCallback(new ListenableFutureCallback<SendResult<String, IndividualResponseDto>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("Сообщение доставлено");

            }

            @Override
            public void onSuccess(SendResult<String, IndividualResponseDto> result) {
                log.info("Сообщение не доставлено");

            }
        });


    }
}
