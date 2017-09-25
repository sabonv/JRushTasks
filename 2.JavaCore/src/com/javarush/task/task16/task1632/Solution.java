package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {


        threads.add(new Th1());
        threads.add(new Th2());
        threads.add(new Th3());
        threads.add(new Th4());
        threads.add(new Th5());

    }


    public static void main(String[] args) {




    }


    static class Th1 extends Thread {

        public void run(){
            while(true){

            }
        }

    }

    static class Th2 extends Thread{

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }

    }

    static class Th3 extends Thread{

        public void run() {

            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);

                }
                catch (InterruptedException e) {
                }

            }

        }

    }

    static class Th4 extends Thread implements Message{

        @Override
        public void showWarning() {
            if (isAlive())
                interrupt();
        }
        public void run() {
            try {
                while (true) Thread.sleep(0);
            }
            catch (InterruptedException e) {}
        }
    }

    static class Th5 extends Thread{

        public int summ;

        public void run() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String temp;

                try {
                    while(!(temp = reader.readLine()).equals("N"))
                    {
                        summ = summ + Integer.parseInt(temp);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }



            System.out.println(summ);

        }

    }

}