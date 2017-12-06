package com.javarush.task.task27.task2712;



import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;


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

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            processOrder(order);
            return order;
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
    }

    private void processOrder(Order order) {
        if (!order.isEmpty()) {

            try{
                new AdvertisementManager(order.getTotalCookingTime()*60).processVideos();
            }catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }
            setChanged();
            notifyObservers(order);

        }
    }

    public void createTestOrder(){
        TestOrder order = null;
        try {
            order = new TestOrder(this);

            processOrder(order);

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
