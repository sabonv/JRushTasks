package com.javarush.task.task14.task1408;

/**
 * Created by v.usov on 18.09.2017.
 */
public class BelarusianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 4;
    }

    @Override
    public String getDescription() {

        String out = super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        return out;
    }
}
