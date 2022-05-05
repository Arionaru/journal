package com.example.journal.service.impl;

import com.example.journal.domain.Event;
import com.example.journal.repository.EventRepository;
import com.example.journal.service.EventService;
import com.example.journalapi.domain.EventDto;
import com.example.journalapi.domain.Source;
import com.example.journalapi.domain.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    @Override
    public void save(EventDto eventDto) {
        Event event = convertDtoToEvent(eventDto);
        eventRepository.save(event);
    }

    private Event convertDtoToEvent(EventDto eventDto) {
        return Event.builder()
                .action(eventDto.getAction())
                .eventTime(eventDto.getEventTime())
                .description(eventDto.getDescription())
                .source(Source.valueOf(eventDto.getSource()))
                .sourceId(eventDto.getSourceId())
                .status(Status.valueOf(eventDto.getStatus()))
                .build();
    }
}
