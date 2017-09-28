package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readerF = new FileInputStream(reader.readLine());
        reader.close();
        List<Integer> listChar = new ArrayList<>();

        int min = 0;
        int temp;
        while (readerF.available() > 0){
            temp = readerF.read();
            if(!listChar.contains(temp)) {
                listChar.add(temp);
            }
        }


        Collections.sort(listChar,
                new Comparator<Integer>() {
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }
        );

        readerF.close();

        for (Integer out: listChar) {
            System.out.print(out + " ");
        }

    }
}
