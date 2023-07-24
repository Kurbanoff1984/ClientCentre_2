package com.kata.clientprofileavatar.kafkaGetMesseg.chekMessegKafcka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.kata.clientprofileavatar.entity.entityKafcka.IspStatysOrderKafkaDto;
import com.kata.clientprofileavatar.kafkaGetMesseg.seviceKafcka.AvatarStatysOrderChekService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Consumer {

    private static final String orderTopic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private final AvatarStatysOrderChekService avatarStatysOrderChekService;


    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("проверка сообщений получены данные {}", message);
        IspStatysOrderKafkaDto ispStatysOrderKafkaDto = objectMapper.readValue(message, IspStatysOrderKafkaDto.class);
        avatarStatysOrderChekService.persistFoodOrder(ispStatysOrderKafkaDto);
    }

}