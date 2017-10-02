package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {

        FileInputStream fileR = new FileInputStream(args[0]);
        Map<Character, Integer> map = new TreeMap<>();

        while (fileR.available() > 0) {
            Character temp;
            if(!map.containsKey((temp = (char)fileR.read()))) {
                map.put(temp, 1);
            }else {
                map.put(temp, map.get(temp)+1);
            }

        }

        fileR.close();

        for (Map.Entry<Character, Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }


        //System.out.println(map);

    }
}
