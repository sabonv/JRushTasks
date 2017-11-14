package com.javarush.task.task27.task2708;

public class Apartment {
    private String location;
    private final RealEstate realEstate;

    public Apartment(RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public  String getLocation() { //synchronized
        synchronized (location) {
            return location;
        }
    }

    public  void setLocation(String location) { //synchronized
        synchronized (location) {
            this.location = location;
        }
    }

    public  void revalidate(boolean isEmpty) { //synchronized
        if (isEmpty)
            realEstate.up(this);
    }
}
