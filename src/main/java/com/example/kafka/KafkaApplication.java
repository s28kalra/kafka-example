package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

	public static final String TOPIC = "topic1";

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
