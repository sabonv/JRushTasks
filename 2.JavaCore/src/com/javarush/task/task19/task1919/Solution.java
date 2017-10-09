package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader fileR1 = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> map = new TreeMap<>();

        while(fileR1.ready()) {

            String[] strArr = fileR1.readLine().split(" ");
            if(!map.containsKey(strArr[0])) {
                map.put(strArr[0], Double.valueOf(strArr[1]));
            }
            else {
                map.put(strArr[0], map.get(strArr[0]) + Double.valueOf(strArr[1]));
            }

        }
        fileR1.close();

        for (Map.Entry<String, Double> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }
}
