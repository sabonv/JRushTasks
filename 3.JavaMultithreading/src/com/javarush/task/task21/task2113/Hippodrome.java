package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses = new ArrayList<>();

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static Hippodrome game;

    public void run() throws InterruptedException{

        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }


    }

    public void move() {

        for (Horse runner: horses) {
            runner.move();
        }

    }

    public void print() {

        for (Horse runner: horses) {
            runner.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }

    }

    public Horse getWinner() {
        double max = 0;
        Horse winner = null;
        for (Horse runner: horses) {
            if(runner.getDistance() > max) {
                max = runner.getDistance();
                winner = runner;
            }
        }

        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args) throws InterruptedException{

        List<Horse> horses = new ArrayList<>();

        horses.add(new Horse("Lucky", 3,0));
        horses.add(new Horse("Rush", 3,0));
        horses.add(new Horse("Slash", 3,0));

        game = new Hippodrome(horses);

        game.run();

        game.printWinner();

    }

}
