package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) throws InterruptedException{

        if(countCreatedThreads < Solution.count) {
            System.out.println(new GenerateThread());
        }


//            Thread.sleep(5000);
//            Thread.currentThread().interrupt();

    }

    public static class GenerateThread extends Thread{

        public GenerateThread() {

            super(String.valueOf(++countCreatedThreads));
            this.start();

        }

        public void run() {
            if (countCreatedThreads < Solution.count) {
                GenerateThread generateThread = new GenerateThread();
                System.out.println(generateThread);
            }
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }
    }
}
