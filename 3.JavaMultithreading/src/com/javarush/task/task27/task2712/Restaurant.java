package com.javarush.task.task27.task2712;



import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.usov on 28.11.2017.
 */
public class Restaurant {

    private static final int ORDER_CREATING_INTERVAL = 100;

    public static void main(String[] args) throws IOException{
        //System.out.println(Dish.allDishesToString());

        //Tablet tablet = new Tablet(5);


        Cook cook1= new Cook("Test");
        Cook cook2 = new Cook("Test2");
        StatisticManager.getInstance().register(cook1);
        StatisticManager.getInstance().register(cook2);

        Waiter waiter = new Waiter();

        cook1.addObserver(waiter);
        cook2.addObserver(waiter);

        OrderManager orderManager = new OrderManager();

        List<Tablet> tabletList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Tablet temp = new Tablet(i);
            temp.addObserver(orderManager);
            temp.addObserver(orderManager);
            tabletList.add(temp);
        }

        //tablet.addObserver(cook1);
        //tablet.createOrder();

        Thread rogt = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        rogt.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            rogt.interrupt();
        }


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();


//        for (Dish dh: getAllDishesForOrder()) {
//            System.out.println(dh.toString());
//        }
    }

}
