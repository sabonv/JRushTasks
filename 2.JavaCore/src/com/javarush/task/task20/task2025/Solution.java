package com.javarush.task.task20.task2025;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {

        long[] result = null;

        List<Long> listL = new ArrayList<>();

        for (long i = N; i >= 0; i--) {

           int m = String.valueOf(i).length();
           double res = 0;
           char[] mArr = String.valueOf(i).toCharArray();

            for (Character chr: mArr) {
                String temp = String.valueOf(chr);
                res = res + Math.pow(Integer.parseInt(temp), m);
            }

            if(i == res) {
                listL.add(i);
            }

        }

        result = new long[listL.size()];
        for (int i = 0; i < listL.size(); i++) {
            result[i] = listL.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

        long startDate = new Date().getTime();
        //System.out.println(startDate);
        long[] out = getNumbers(1000000000);

        for (long vot: out) {
            System.out.print(vot + " ");
        }
        long stopDate = new Date().getTime();
        System.out.println();
        System.out.println((stopDate - startDate));
    }
}
//http://rextester.com/KHEI65875
//http://www.cyberforum.ru/java-j2se/thread1743615.html