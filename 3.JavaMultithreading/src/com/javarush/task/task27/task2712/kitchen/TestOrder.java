package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by v.usov on 06.12.2017.
 */
public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {


        int randomValuesDishesInTestOrder = (int) Math.round(Math.random() * 2 + 1);
        int valueVariantsOfDishes = Dish.values().length;
        ArrayList<Dish> arrayDishes = new ArrayList<>(Arrays.asList(Dish.values()));

        for (int i = 0; i < randomValuesDishesInTestOrder; i++) {
            dishes.add(arrayDishes.get((int) Math.round(Math.random() * (valueVariantsOfDishes - 1))));
        }

    }
}
