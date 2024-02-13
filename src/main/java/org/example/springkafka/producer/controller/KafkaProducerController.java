package org.example.springkafka.producer.controller;

import org.example.springkafka.producer.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class KafkaProducerController {
    final KafkaProducerService kafkaProducerService;
    public KafkaProducerController(final KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/publish/{message}")
    public ResponseEntity<Void> publishMessage(@PathVariable String message) {
        kafkaProducerService.sendMessage("TEST", message);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
