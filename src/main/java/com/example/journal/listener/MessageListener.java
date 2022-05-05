package com.example.journal.listener;

import com.example.journal.service.EventService;
import com.example.journalapi.domain.EventDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {
    private final EventService eventService;

    @KafkaListener(topics = "${spring.kafka.topics.journal-request}",
            groupId = "${spring.kafka.consumer.group-id}",
            clientIdPrefix = "${spring.kafka.consumer.client-id}",
            idIsGroup = false,
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeMessage(ConsumerRecord<String, EventDto> record) {
        eventService.save(record.value());
    }
}
