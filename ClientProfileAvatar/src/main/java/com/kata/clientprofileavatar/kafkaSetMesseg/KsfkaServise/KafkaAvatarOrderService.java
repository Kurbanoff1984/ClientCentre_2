package com.kata.clientprofileavatar.kafkaSetMesseg.KsfkaServise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kata.clientprofileavatar.entity.entityKafcka.IspStatysOrderKafkaDto;
import com.kata.clientprofileavatar.kafkaSetMesseg.producerKafcka.Producer;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaAvatarOrderService {

    private final Producer producer;

    @Autowired
    public KafkaAvatarOrderService(Producer producer) {
        this.producer = producer;
    }

    public String createFoodOrder(IspStatysOrderKafkaDto foodOrder) {
        try {
            return producer.sendMessage(foodOrder);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Передача через кафку прошла неудачно ощибка JsonProcessingException = "+e);
        }

    }
}