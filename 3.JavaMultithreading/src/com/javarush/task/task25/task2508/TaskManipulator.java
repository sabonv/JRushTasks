package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    public Thread target;

    @Override
    public void run() {
        try {
            while (!target.isInterrupted()) {
                Thread.sleep(0);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
        }
        //System.out.println(target.getName());

    }

    @Override
    public void start(String threadName) {

        this.target = new Thread(this);
        this.target.setName(threadName);
        this.target.start();
    }

    @Override
    public void stop() {
        target.interrupt();
    }
}
