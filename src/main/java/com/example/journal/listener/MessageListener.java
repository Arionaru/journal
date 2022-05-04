package com.example.journal.listener;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {
    @KafkaListener(topics = "${spring.kafka.topics.journal-request}",
            groupId = "${spring.kafka.consumer.group-id}",
            clientIdPrefix = "${spring.kafka.consumer.client-id}",
            idIsGroup = false,
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeMessage(ConsumerRecord<String, Object> record) {
        try {
            System.out.println(record.value());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
