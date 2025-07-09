package com.msg.messaging_springboot;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class HelloConsumer {

    @KafkaListener(topics = "hello-topic", groupId = "group-1")
    public void receiverMessage(String message) {
        System.out.println("Consumer Message: " + message);
    }

}


