package com.example.kafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.service.Producer;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class KafkaController {
	
	private Producer producer;
	
	@GetMapping("/produce/{message}")
	public String produceMessage(@PathVariable String message) {
		producer.sendMsgToTopic(message);
		return message;
	}

}
