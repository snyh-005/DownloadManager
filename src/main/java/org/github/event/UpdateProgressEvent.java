package org.github.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Map;


@Getter
public class UpdateProgressEvent extends ApplicationEvent {

    public Map<String, Double> message;

    public UpdateProgressEvent(Object source, Map<String, Double> message) {
        super(source);
        this.message = message;
    }
}
