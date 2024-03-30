package org.github.snyh005.event;

import lombok.Getter;
import org.github.snyh005.utils.ProgressManager;
import org.springframework.context.ApplicationEvent;

import java.util.Map;


@Getter
public class UpdateProgressEvent extends ApplicationEvent {

    private final Map<String, Double> message;

    public UpdateProgressEvent(Object source) {
        super(source);
        this.message = ProgressManager.getInstance().getProgress().get();
    }
}
