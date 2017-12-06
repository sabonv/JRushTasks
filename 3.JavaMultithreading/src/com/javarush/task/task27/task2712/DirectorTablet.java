package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;


import java.text.SimpleDateFormat;
import java.util.*;

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
        ArrayList<Advertisement> activeAdvList = StatisticAdvertisementManager.getOurInstance().getAdvertisementsFromStorage().get("Active");
        Collections.sort(activeAdvList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad : activeAdvList) {
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }

    public void printArchivedVideoSet() {
        ArrayList<Advertisement> archiveAdvList = StatisticAdvertisementManager.getOurInstance().getAdvertisementsFromStorage().get("Archive");
        Collections.sort(archiveAdvList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad : archiveAdvList) {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }


}
