package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by v.usov on 28.11.2017.
 */
public enum Dish {

    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        String result = "";
        for (Enum<Dish> dsh: Dish.values()) {
            result = result + dsh.toString() + ", ";
        }

        return result.substring(0,result.length()-2);
    }

}
