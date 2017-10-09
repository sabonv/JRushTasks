package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws  Exception {
        if (args.length > 0) {
            BufferedReader fileR1 = new BufferedReader(new FileReader(args[0]));


            Map<String, Double> map = new HashMap<>();

            while (fileR1.ready()) {

                String[] strArr = fileR1.readLine().split(" ");
                if (!map.containsKey(strArr[0])) {
                    map.put(strArr[0], Double.valueOf(strArr[1]));
                } else {
                    map.put(strArr[0], map.get(strArr[0]) + Double.valueOf(strArr[1]));
                }

            }

            fileR1.close();
            Map<Double, String> mapD = new TreeMap<>();

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                mapD.put(pair.getValue(), pair.getKey());
            }

            List<Double> tempDL = new ArrayList<>();

            for (Map.Entry<Double, String> pair : mapD.entrySet()) {
                tempDL.add(pair.getKey());
            }

            for (Map.Entry<String, Double> pair : map.entrySet()) {
                if(pair.getValue().equals(tempDL.get(tempDL.size() - 1))) {
                    System.out.println(pair.getKey());
                }
            }


        }
    }
}
