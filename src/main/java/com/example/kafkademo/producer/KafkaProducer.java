package com.example.kafkademo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate; // Key & Value

    public void sendMessage(String message) {

        log.info(String.format("Sending message to Topic : %s", message));

        kafkaTemplate.send("Topic-Name01", message);
    }
}
