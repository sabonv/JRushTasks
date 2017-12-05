package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by v.usov on 05.12.2017.
 */
public class DirectorTablet {

    public void printAdvertisementProfit() {

        double summ = 0;
        for (Map.Entry<Date, Double> pair: StatisticManager.getInstance().advertisementProfit().entrySet()) {

            SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            ConsoleHelper.writeMessage(dataFormat.format(pair.getKey()) + " - " + String.format(Locale.ENGLISH, "%(.2f", pair.getValue()));
            summ += pair.getValue();
        }

        ConsoleHelper.writeMessage("Total - " + String.format(Locale.ENGLISH, "%(.2f", summ));
    }

    public void printCookWorkloading() {

        for (Map.Entry<Date, TreeMap<String, Integer>> date: StatisticManager.getInstance().cookWorkloading().entrySet()) {

            SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            ConsoleHelper.writeMessage(dataFormat.format(date.getKey()));

            for (Map.Entry<String, Integer> cooks: date.getValue().entrySet()) {

                ConsoleHelper.writeMessage(cooks.getKey() + " - " + (int) Math.ceil(cooks.getValue() / 60.0d) + " min");

            }

            ConsoleHelper.writeMessage("");
        }

    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet(){

    }
}
