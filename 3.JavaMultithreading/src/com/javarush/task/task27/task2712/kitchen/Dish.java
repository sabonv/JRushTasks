package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by v.usov on 28.11.2017.
 */
public enum Dish {

    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString(){
        String result = "";
        for (Enum<Dish> dsh: Dish.values()) {
            result = result + dsh.toString() + ", ";
        }

        return result.substring(0,result.length()-2);
    }

    public int getDuration() {
        return duration;
    }
}
