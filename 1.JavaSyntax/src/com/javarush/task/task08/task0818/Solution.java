package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> tempmap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            tempmap.put("zhaba"+i, (int)(Math.random()*1000));
        }
        return tempmap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> temps = new ArrayList<>();

        for (Map.Entry<String, Integer> para: map.entrySet()) {
            if (para.getValue() < 500) temps.add(para.getKey());
        }

        for (int i = 0; i < temps.size(); i++) {
            map.remove(temps.get(i));
        }
    }

    public static void main(String[] args) {

        HashMap<String, Integer> book = createMap();
        removeItemFromMap(book);
    }
}