package com.javarush.task.task27.task2712;



import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

import static com.javarush.task.task27.task2712.ConsoleHelper.getAllDishesForOrder;

/**
 * Created by v.usov on 28.11.2017.
 */
public class Restaurant {


    public static void main(String[] args) throws IOException{
        //System.out.println(Dish.allDishesToString());

        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Test");
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet.addObserver(cook);
        tablet.createOrder();

//        for (Dish dh: getAllDishesForOrder()) {
//            System.out.println(dh.toString());
//        }
    }

}
