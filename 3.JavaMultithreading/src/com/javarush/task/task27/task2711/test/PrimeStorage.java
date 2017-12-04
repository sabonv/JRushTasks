package com.javarush.task.task27.task2711.test;

import java.util.ArrayList;
import java.util.List;

public class PrimeStorage {

    private static PrimeStorage instance;
    private List<Prime> primeList = new ArrayList<>();

    private PrimeStorage() {
        primeList.add(new Prime("First", 100, 10));
        primeList.add(new Prime("Second", 200, 20));
        primeList.add(new Prime("Third", 300, 30));
        primeList.add(new Prime("First1", 1100, 200));
        primeList.add(new Prime("Second2", 1200, 300));
        primeList.add(new Prime("Third3", 1000, 150));
    }

    public static PrimeStorage getInstance() {
        if (instance == null) instance = new PrimeStorage();

        return instance;
    }

    public List<Prime> list() {
        return primeList;
    }

}
