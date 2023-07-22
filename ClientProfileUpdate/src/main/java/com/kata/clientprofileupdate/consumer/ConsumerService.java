package com.kata.clientprofileupdate.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Тестовый приемник сообщений kafka из очереди
 */
@Service
public class ConsumerService {
    @KafkaListener(topics = "testTopic", groupId = "group_id")
    public void consume(String message) {
        if (message.contains("A")) {
            System.out.println("Consumed message contains A " + message);
        }
        System.out.println("Consumed message " + message);
    }
}
