package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by v.usov on 28.11.2017.
 */
public class Cook extends Observable implements Observer{

    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        //ConsoleHelper.writeMessage(arg.toString());
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString() + ", cooking time " + order.getTotalCookingTime() + "min");

        setChanged();
        notifyObservers(arg);

    }

    @Override
    public String toString() {
        return name;
    }
}
