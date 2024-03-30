package org.github.snyh005.utils;

import lombok.Getter;
import org.github.snyh005.event.publisher.UpdateProgressEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * A singleton pattern is used as a volatile object is used
 *  to store the progress of downloads happening concurrently
 */
@Getter
public class ProgressManager {

    private static volatile ProgressManager instance;

    private final ThreadLocal<Map<String, Double>> progress;

    public static int instanceCount = 0;

    public ProgressManager() {
        this.progress = ThreadLocal.withInitial(()-> new ConcurrentHashMap<>());
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
        this.progress.get().put(key, value);
    }
}
