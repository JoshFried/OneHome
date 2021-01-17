package com.htne.helpthehomeless.dal.service.events;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AvailableSpotEventPublisher {
    private final ApplicationEventPublisher publisher;

    public void publishEvent(final long shelterId) {
        publisher.publishEvent(new AvailableSpotEvent(shelterId));
    }
}
