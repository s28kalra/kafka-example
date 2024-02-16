package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.example.kafka.KafkaApplication;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumer {

	@KafkaListener(groupId = "email-consumer-group", topicPartitions = {
			@TopicPartition(topic = KafkaApplication.TOPIC, partitions = { "0" }) })
	public void consumer1(String message) {
		log.info("Email Consumer message: {}", message);
	}

	@KafkaListener(groupId = "sms-consumer-group", topicPartitions = {
			@TopicPartition(topic = KafkaApplication.TOPIC, partitions = { "0" }) })
	public void consumer2(String message) {
		log.info("SmS Consumer message: {}", message);
	}

}
