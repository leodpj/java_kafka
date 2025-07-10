package com.msg.messaging_springboot;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloProducer {
    private KafkaTemplate<String, String> kafkaTemplate;

    public HelloProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate =kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("hello-topic", message);
    }

}
// This class is responsible for sending messages to the Kafka topic "hello-topic".
// It uses the KafkaTemplate to send messages, which is configured in the application.properties file.
// The sendMessage method takes a String message as a parameter and sends it to the specified topic.