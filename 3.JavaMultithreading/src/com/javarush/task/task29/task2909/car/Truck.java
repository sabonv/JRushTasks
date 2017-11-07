package com.javarush.task.task29.task2909.car;

/**
 * Created by v.usov on 07.11.2017.
 */
public class Truck extends Car {

    public Truck(int numberOfPassengers) {
        super(TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
