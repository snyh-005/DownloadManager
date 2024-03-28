package org.github.event.listener;

import org.github.event.UpdateProgressEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class UpdateProgressEventListener implements ApplicationListener<UpdateProgressEvent> {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Override
    public void onApplicationEvent(UpdateProgressEvent event) {
        messagingTemplate.convertAndSend("/topic/download",event.getMessage());
    }
}
