package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

//    public void processVideos() {
//        //ConsoleHelper.writeMessage("calling processVideos method");
//        List<Advertisement> allVideo = storage.list();
//        if (allVideo.isEmpty()) throw new NoVideoAvailableException();
//    }

    public void processVideos() {
        List<Advertisement> videoForViwe =  getVideos(timeSeconds, storage.list(), storage.list().size());

        if (videoForViwe == null || videoForViwe.isEmpty())
            throw new NoVideoAvailableException();

        Collections.sort(videoForViwe, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) ((o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying()) ?
                        o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying() :
                        o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() -
                                o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
            }
        });
        for (Advertisement a : videoForViwe) {
            a.revalidate();
            ConsoleHelper.writeMessage(a.getName() + " is displaying... " + a.getAmountPerOneDisplaying() + ", " +
                    a.getAmountPerOneDisplaying() * 1000 / a.getDuration());
        }
    }

    private List<Advertisement> getVideos(int W, List<Advertisement> adL, int n) {
        if (n == 0 || W == 0)
            return null;

        if (adL.get(n-1).getDuration() > W || adL.get(n-1).getHits() <= 0)
            return getVideos(W, adL, n-1);

        else {
            List<Advertisement> l1 = new ArrayList<>();
            l1.add(adL.get(n-1));
            List<Advertisement> t = getVideos(W - adL.get(n - 1).getDuration(), adL, n - 1);

            if (t != null) l1.addAll(t);

            List<Advertisement> l2 = getVideos(W, adL, n - 1);

            if (getTotalAmount(l1) == getTotalAmount(l2))
                if (getTotalTime(l1) == getTotalTime(l2)) {
                    return (l1.size() < (l2 != null ? l2.size() : Integer.MAX_VALUE)) ? l1 : l2;
                } else
                    return (getTotalTime(l1) > getTotalTime(l2)) ? l1 : l2;
            else return (getTotalAmount(l1) > getTotalAmount(l2)) ? l1 : l2;
        }
    }

    private long getTotalAmount(List<Advertisement> ad) {
        long totalAmount = 0;
        if (ad == null) return totalAmount;
        for (Advertisement a : ad) {
            totalAmount += a.getAmountPerOneDisplaying();
        }
        return totalAmount;
    }
    private int getTotalTime(List<Advertisement> ad) {
        int totalTime = 0;
        if (ad == null) return totalTime;
        for (Advertisement a : ad) {
            totalTime += a.getDuration();
        }
        return totalTime;
    }

}
