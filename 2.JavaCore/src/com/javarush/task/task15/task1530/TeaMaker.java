package com.javarush.task.task15.task1530;

/**
 * Created by v.usov on 20.09.2017.
 */
public class TeaMaker extends DrinkMaker {

    @Override
    void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    void pour() {
        System.out.println("Заливаем кипятком");
    }
}
