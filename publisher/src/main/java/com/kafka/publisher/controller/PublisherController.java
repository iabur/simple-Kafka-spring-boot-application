package com.kafka.publisher.controller;

import com.kafka.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("topic")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PutMapping("/publish")
    public ResponseEntity publishTopic() throws InterruptedException {
        int count = 100;
        while (count > 0) {
            publisherService.publishMessage("Rider " + count);
            Thread.sleep(1000);
            count--;
        }

        return new  ResponseEntity<>(Map.of("message", "Rider published successfully"), HttpStatus.OK);
    }
}
