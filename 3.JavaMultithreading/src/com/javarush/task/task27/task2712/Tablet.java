package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Order;



import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by v.usov on 28.11.2017.
 */
public class Tablet extends Observable {

    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());


    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        try {
            Order order = new Order(this);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }



    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
