package com.javarush.task.task14.task1408;

/**
 * Created by v.usov on 18.09.2017.
 */
public abstract class Hen {

    private String counry = "";

    public Hen Hen(String county){
        this.counry = county;

        return this;
    }

    abstract int getCountOfEggsPerMonth();

    String getDescription(){
        return "Я — курица.";
    }
}
