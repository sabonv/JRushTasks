package com.javarush.task.task27.task2712.statistic;



import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;


import java.util.*;

public class StatisticManager {

    private static final StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {
    }

    public static StatisticManager getInstance(){
        return ourInstance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<Date, Double> advertisementProfit(){
        Map<Date, Double> result = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });

        List<EventDataRow> adEv = new ArrayList<>();
        adEv.addAll(statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS));

        for (EventDataRow edr: adEv) {
            VideoSelectedEventDataRow temp = (VideoSelectedEventDataRow) edr;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(temp.getDate());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);


            if (result.containsKey(calendar.getTime())) result.put(calendar.getTime(), result.get(calendar.getTime()) + temp.getAmount()/100.00);
            else result.put(calendar.getTime(), temp.getAmount()/100.00);
        }

        return result;
    }

    public Map<Date, TreeMap<String, Integer>> cookWorkloading(){

        Map<Date, TreeMap<String, Integer>> result = new TreeMap<>(new Comparator<Date>(){
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });

        List<EventDataRow> adEv = new ArrayList<>();
        adEv.addAll(statisticStorage.getStorage().get(EventType.COOKED_ORDER));

        for (EventDataRow edr: adEv) {
            CookedOrderEventDataRow temp = (CookedOrderEventDataRow) edr;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(temp.getDate());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);


            if (result.containsKey(calendar.getTime())) {

                TreeMap<String, Integer> tempM = result.get(calendar.getTime());

                if(tempM.containsKey(temp.getCookName())) tempM.put(temp.getCookName(), tempM.get(temp.getCookName()) + temp.getTime());
                else tempM.put(temp.getCookName(), temp.getTime());

                result.put(calendar.getTime(), (TreeMap)tempM.clone());
            }

            else {
                TreeMap<String, Integer> tempM = new TreeMap<>();
                tempM.put(temp.getCookName(), temp.getTime());
                result.put(calendar.getTime(), (TreeMap)tempM.clone());
            }
        }

        return result;
    }

    private static class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {

            for (EventType evt: EventType.values()) {
                storage.put(evt, new ArrayList<EventDataRow>());
            }

        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }

}
