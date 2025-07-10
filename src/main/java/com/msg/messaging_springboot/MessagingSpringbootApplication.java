package com.msg.messaging_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MessagingSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingSpringbootApplication.class, args);
	}
}

@RestController
@RequestMapping("/kafka")
class MessagingController {
	@Autowired
	private HelloProducer service;

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		service.sendMessage("Olá, " + name);
		return "OK";
	}
}

// Compare this snippet from src/main/resources/application.properties:
// # Kafka properties
// spring.kafka.bootstrap-servers=localhost:9092
// spring.kafka.consumer.group-id=group-1
// spring.kafka.consumer.auto-offset-reset=earliest
// spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
// spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
// spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
// spring.kafka.producer.value-serializer=org.apache.kafka.common.serialization.StringSerializer