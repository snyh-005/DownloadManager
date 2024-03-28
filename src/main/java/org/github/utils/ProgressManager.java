package org.github.utils;

import lombok.Getter;
import org.github.event.publisher.UpdateProgressEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * A singleton pattern is used as a volatile object is used
 *  to store the progress of downloads happening concurrently
 */
public class ProgressManager {

    private static volatile ProgressManager instance;
    @Getter
    private final Map<String, Double> progress;

    @Autowired
    UpdateProgressEventPublisher event;

    public static int instanceCount = 0;

    public ProgressManager() {
        this.progress = new ConcurrentHashMap<>();
    }

    public static ProgressManager getInstance(){
        if(null == instance) {
            synchronized (ProgressManager.class) {
                if (null == instance) {
                    instance = new ProgressManager();
                    instanceCount++;
                }
            }
        }
        return instance;
    }

    public void updateProgress(String key, Double value){
        this.progress.put(key, value);
        event.publish();
    }
}
