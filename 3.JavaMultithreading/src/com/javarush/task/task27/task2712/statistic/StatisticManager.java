package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;

public class StatisticManager {

    private static final StatisticManager ourInstance = new StatisticManager();

    private StatisticManager() {
    }

    public static StatisticManager getInstance(){
        return ourInstance;
    }

    public void register(EventDataRow data){

    }
}
