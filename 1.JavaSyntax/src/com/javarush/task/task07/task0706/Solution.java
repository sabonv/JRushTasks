package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] doma = new int[15];
        int ev=0, od=0;

        for (int i = 0; i < doma.length; i++) {
            doma[i] = Integer.parseInt(read.readLine());
            if ((i%2 == 0) || (i == 0)) ev = ev + doma[i];
            else od = od + doma[i];
        }

        if (ev > od) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}
