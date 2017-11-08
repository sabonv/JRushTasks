package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by v.usov on 08.11.2017.
 */
public class Producer implements Runnable{

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                map.put(String.valueOf(i), "Some text for " + i);
                Thread.sleep(500);
                i++;
            }catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " thread was terminated");
            }

        }

    }
}
