package org.github.snyh005.utils;

import org.github.snyh005.utils.ProgressManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgressManagerTests {

    ProgressManager instance;
    @Test
    public void testGetInstance_Create(){
        instance = null;
        assertNotNull(ProgressManager.getInstance());
    }

    @Test
    public void testGetInstance_Exists(){
        assertNotNull(ProgressManager.getInstance());
    }

    @Test
    public void testGetInstance_Concurrency() throws InterruptedException {
        Thread[] threads = new Thread[10];

        for(int i=0;i<10;i++){
            threads[i]= new Thread(() ->{
                    instance = ProgressManager.getInstance();
            });
        }

        for(Thread thread: threads){
            thread.start();
        }

        for(Thread thread: threads){
            thread.join();
        }

        assertNotNull(instance);
        assertEquals(1, ProgressManager.instanceCount);
    }

}
