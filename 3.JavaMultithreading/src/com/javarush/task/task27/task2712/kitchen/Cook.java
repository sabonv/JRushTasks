package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by v.usov on 28.11.2017.
 */
public class Cook implements Observer{

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " + (Order)arg);
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';
    }
}
