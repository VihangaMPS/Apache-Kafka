package com.example.kafkademo.controller;

import com.example.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    private ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok(message);
    }
}
