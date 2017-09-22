package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут

            Thread.sleep(3500);
            clock.interrupt();
            //System.out.println("Прервано!");


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                for (int i = countSeconds; i > 0; i--) {
                    System.out.print(countSeconds + " ");
                    Thread.sleep(1000);
                    countSeconds--;
                }
                System.out.println("Марш!");
            }
            catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
        }
    }
}
