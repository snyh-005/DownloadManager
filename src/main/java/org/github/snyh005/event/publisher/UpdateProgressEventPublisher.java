package org.github.snyh005.event.publisher;

import org.github.snyh005.event.UpdateProgressEvent;
import org.github.snyh005.utils.ProgressManager;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UpdateProgressEventPublisher {

    private final ApplicationEventPublisher publisher;

    public UpdateProgressEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void publish(){
        ApplicationEvent event = new UpdateProgressEvent(this);
        publisher.publishEvent(event);
    }
}
