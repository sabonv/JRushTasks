package com.javarush.task.task14.task1408;

/**
 * Created by v.usov on 18.09.2017.
 */
public class MoldovanHen  extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }

    @Override
    String getDescription() {

        String out = super.getDescription() + " Моя страна - " + "county" + " Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        return out;
    }

}
