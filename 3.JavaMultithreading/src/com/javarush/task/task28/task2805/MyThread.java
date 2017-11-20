package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by v.usov on 20.11.2017.
 */
public class MyThread extends Thread {

    public static AtomicInteger priorT = new AtomicInteger(0);
    public AtomicInteger priorG = new AtomicInteger(this.getThreadGroup().getMaxPriority());

    public MyThread() {
        if (priorT.get() >= 10) priorT.set(0);
        this.setPriority(priorT.incrementAndGet());

    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (priorT.get() >= 10) priorT.set(0);
        if (priorT.get() >= priorG.get()) priorT.set(priorG.get() - 1);
        this.setPriority(priorT.incrementAndGet());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
