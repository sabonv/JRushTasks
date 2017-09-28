package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readerF = new FileInputStream(reader.readLine());
        reader.close();
        Map<Integer, Integer> mapChar = new HashMap();

        int max = 0;
        int temp;
        while (readerF.available() > 0){

            temp = readerF.read();
            if(!mapChar.containsKey(temp)) {
                mapChar.put(temp, 1);
            } else {

                mapChar.put(temp, mapChar.get(temp) + 1);
            }
            if (mapChar.get(temp)> max) max = mapChar.get(temp);
        }
        readerF.close();

        for (Map.Entry<Integer, Integer> pair: mapChar.entrySet()) {
            if(pair.getValue() == max) System.out.print(pair.getKey() + " ");
        }

        //System.out.println(mapChar);


    }
}
