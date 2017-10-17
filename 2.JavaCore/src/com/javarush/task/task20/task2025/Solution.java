package com.javarush.task.task20.task2025;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {

    public static int[] getNumbers(long N) {

        List<Integer> listN = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            int length = 1;
            if(i != 0) length = (int) (Math.log10(i) + 1);

            if(length == 1) listN.add(i);

            else if (length == 2) {

            }




        }

        return null;
    }

    public static void main(String[] args) {

        long startDate = new Date().getTime();

        //System.out.println(startDate);


        int[] out = getNumbers(380);

        for (long vot: out) {
            System.out.print(vot + " ");
        }




        System.out.println();
        System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024/1024 + " MB");
        System.out.println((new Date().getTime()- startDate));

    }
}
