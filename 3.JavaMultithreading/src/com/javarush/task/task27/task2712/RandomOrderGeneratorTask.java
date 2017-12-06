package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.usov on 06.12.2017.
 */
public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tabletList;
    private int pause;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int pause) {
        this.tabletList = tabletList;
        this.pause = pause;
    }

    @Override
    public void run() {

        while (tabletList.size() >0) {
            Tablet tablet = tabletList.get((int) (Math.random() * (tabletList.size() - 1)));
            tablet.createTestOrder();

            try {
                Thread.sleep(pause);
            }catch (InterruptedException e) {
                break;
            }

        }

    }
}
