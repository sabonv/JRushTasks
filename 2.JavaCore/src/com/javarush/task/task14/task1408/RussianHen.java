package com.javarush.task.task14.task1408;

/**
 * Created by v.usov on 18.09.2017.
 */
public class RussianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    public String getDescription() {

        String out = super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        return out;
    }
}
