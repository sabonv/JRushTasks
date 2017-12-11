package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by v.usov on 11.12.2017.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            for (int i = 1; i < 10; i++) {
                if (Thread.currentThread().isInterrupted()) break;

                System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);

                queue.offer(new ShareItem("ShareItem-" + i, i));
                Thread.sleep(100);

                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!%n");

                }
            }
        }catch (InterruptedException e) {

        }

    }
}
