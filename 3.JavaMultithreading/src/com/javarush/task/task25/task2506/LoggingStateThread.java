package com.javarush.task.task25.task2506;

/**
 * Created by v.usov on 03.11.2017.
 */
public class LoggingStateThread extends Thread{

    public Thread target;

    public LoggingStateThread(Thread target){
        this.target = target;
        //System.out.println(target.getState());
    }
    @Override
    public void run() {
        Thread.State currentState = target.getState();
        System.out.println(currentState);
        super.run();
        while (!currentState.equals(State.TERMINATED)) {
            Thread.State newState = target.getState();
            if (!newState.equals(currentState)) {
                System.out.println(newState);
                currentState = newState;
            }
        }
        this.interrupt();
    }


}
