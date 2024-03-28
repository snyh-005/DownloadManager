package org.github.event.publisher;

import org.github.event.UpdateProgressEvent;
import org.github.utils.ProgressManager;
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
        ApplicationEvent event = new UpdateProgressEvent(this, ProgressManager.getInstance().getProgress());
        publisher.publishEvent(event);
    }
}
