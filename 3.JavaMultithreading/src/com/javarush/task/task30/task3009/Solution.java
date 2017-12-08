package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
//        getRadix("9978799");
    }

    private static Set<Integer> getRadix(String number) {

        Set<Integer> result = new HashSet<>();

            for (int i = 2; i < 37; i++) {
                try {
                    Integer temp = Integer.parseInt(number);
                    StringBuilder  temp1 = new StringBuilder(Integer.toString(temp, i));
                    if (palindrom(temp1.toString())) result.add(i);
                }catch (NumberFormatException e) {}
            }


        return result;
    }

    private static boolean palindrom(String str){

        boolean flag = true;

        int count = 0;
        if (str.length()%2 == 0) count = str.length()/2;
        else count = (str.length()-1)/2;
        int i = 0;

        for (int j = str.length(); j > str.length()-count ; j--) {
            if (!str.substring(i, i+1).equals(str.substring(j-1,j))){
                flag = false;
                break;
            }
            i++;
        }


        return flag;
    }
}