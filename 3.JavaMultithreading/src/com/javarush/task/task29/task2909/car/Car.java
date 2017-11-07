package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final int MAX_TRUCK_SPEED = 80;
    static public final int MAX_SEDAN_SPEED = 120;
    static public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
        //return 0;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {

        if(isSummer(date, SummerStart, SummerEnd)) return getSummerConsumption(length);
        else return getWinterConsumption(length);


//        double consumption;
//        if (date.before(SummerStart) || date.after(SummerEnd)) {
//            consumption = length * winterFuelConsumption + winterWarmingUp;
//        } else {
//            consumption = length * summerFuelConsumption;
//        }
//        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {

        if(canPassengersBeTransferred()) return numberOfPassengers;
        else return 0;

//        if (!isDriverAvailable())
//            return 0;
//        if (fuel <= 0)
//            return 0;
//
//        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
//    {
//        if (type == TRUCK)
//            return MAX_TRUCK_SPEED;
//        if (type == SEDAN)
//            return MAX_SEDAN_SPEED;
//        return MAX_CABRIOLET_SPEED;
//    }

    public static Car create(int type, int numberOfPassengers){
        Car car = null;

        switch (type){

            case CABRIOLET : {
                car = new Cabriolet(numberOfPassengers);
                break;
            }
            case TRUCK : {
                car = new Truck(numberOfPassengers);
                break;
            }
            case SEDAN : {
                car = new Sedan(numberOfPassengers);
                break;
            }

        }

        return car;
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd) {

        return date.before(summerStart) || date.after(summerEnd) ? false : true;
    }

    public double getWinterConsumption(int length) {

        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {

        return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred() {

        return isDriverAvailable() && fuel > 0 ? true : false;
    }

}