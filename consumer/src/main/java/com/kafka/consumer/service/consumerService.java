package com.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class consumerService {

    @KafkaListener(topics = TOPIC, groupId = "user-group")
    public void messages(String message) {
        System.out.println("Message received: " + message);
    }
}
