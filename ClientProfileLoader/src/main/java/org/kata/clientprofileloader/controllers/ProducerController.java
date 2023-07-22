package org.kata.clientprofileloader.controllers;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Тестовый контроллер продюсер - для сообщений kafka, который помещает сообщения в очередь
 */
@RestController
@AllArgsConstructor
public class ProducerController {
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "testTopic";
    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message sent - " + message;
    }
}
