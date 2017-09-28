package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readerF = new FileInputStream(reader.readLine());
        reader.close();
        Map<Integer, Integer> mapChar = new HashMap();

        int min = 1;
        int temp;
        while (readerF.available() > 0){

            temp = readerF.read();
            if(!mapChar.containsKey(temp)) {
                mapChar.put(temp, 1);
            } else {

                mapChar.put(temp, mapChar.get(temp) + 1);
            }

        }
        readerF.close();


        try {
            min=(Collections.min(mapChar.values()));
        }
        catch (NoSuchElementException e) {}



//        List<Integer> sortV = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> pair: mapChar.entrySet()) {
//            sortV.add(pair.getValue());
//        }
//
//        Collections.sort(sortV,
//                new Comparator<Integer>() {
//                    public int compare(Integer o1, Integer o2) {
//                        return o2 - o1;
//                    }
//                }
//        );
//
//        min = sortV.get(sortV.size()-1);

        for (Map.Entry<Integer, Integer> pair: mapChar.entrySet()) {
            if(pair.getValue() == min) System.out.print(pair.getKey() + " ");
        }

    }
}
