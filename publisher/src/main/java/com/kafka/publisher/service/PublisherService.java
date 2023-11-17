package com.kafka.publisher.service;

import com.kafka.publisher.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public PublisherService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String message) {
        kafkaTemplate.send(AppConstant.TOPIC, message);
    }
}