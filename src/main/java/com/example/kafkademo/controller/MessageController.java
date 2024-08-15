package com.example.kafkademo.controller;

import com.example.kafkademo.payload.Student;
import com.example.kafkademo.producer.KafkaJSONProducer;
import com.example.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJSONProducer kafkaJSONProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message sent successfully as String to Kafka");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message) {
        kafkaJSONProducer.sendMessage(message);

        return ResponseEntity.ok("Message sent successfully as JSON to Kafka");
    }
}
