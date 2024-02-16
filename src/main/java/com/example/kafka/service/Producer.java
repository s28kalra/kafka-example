package com.example.kafka.service;

import java.util.List;

import org.apache.kafka.common.PartitionInfo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.KafkaApplication;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class Producer {

	private KafkaTemplate<String, String> template;

	public void sendMsgToTopic(String message) {
		List<PartitionInfo> partitions = template.partitionsFor(KafkaApplication.TOPIC);
		int hash = Math.abs(message.hashCode());
		int partition = hash % partitions.size();
		log.info("Producer message: {}: partition: {}", message, partition);
		template.send(KafkaApplication.TOPIC, partition, null, message);
	}

}
