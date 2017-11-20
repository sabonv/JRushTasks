package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by v.usov on 20.11.2017.
 */
public class MyThread extends Thread {

    public static AtomicInteger priorT = new AtomicInteger(1);
    //public AtomicInteger priorG = new AtomicInteger(this.getThreadGroup().getMaxPriority());

    public MyThread() {
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }

    }

    public MyThread(Runnable target) {
        super(target);
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }
    }

    public MyThread(String name) {
        super(name);
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (priorT.get() < 10) setPriority(priorT.getAndIncrement());
        else {
            setPriority(priorT.get());
            priorT.set(1);
        }
    }
}
