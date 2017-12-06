package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.usov on 06.12.2017.
 */
public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {

        List<Dish> result = new ArrayList<>();
        int count = (int) Math.random() * (Dish.values().length -1);

        for (int i = 0; i < count; i++) {
            int dishi = (int) Math.random() * (Dish.values().length -1);

            if (!result.contains(Dish.values()[i])) result.add(Dish.values()[i]);

        }

    }
}
