package com.javarush.task.task20.task2025;


import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    public static int[] getNumbers(long N) {

        List<Integer> listN = new ArrayList<>();
        List<Integer> lisiTest = new ArrayList<>();

        int count = 0;
        Set<Integer> setAN = new TreeSet<>();
        for (int i = 0; i <= N; i++) {
            if(isNumberUnique(i)) {
                listN.add(i);
                count++;
                int firstN = summAM(i);
                if(!setAN.contains(firstN)) {
                    if (isANumber(firstN) && firstN <= N) lisiTest.add(firstN);
                }
            }
        }

        //-----------
        System.out.println(listN);
        //System.out.println(listN.size());

//        List<Integer> listAN = new ArrayList<>();
//
//
//        for (Integer testN: listN) {
//            int firstN = summAM(testN);
//            if(!setAN.contains(firstN)) {
//                if (isANumber(firstN) && firstN <= N) setAN.add(firstN);
//            }
//        }
        System.out.println(count);
        System.out.println(lisiTest);
        System.out.println(setAN);

        return null;
    }


    private static boolean isANumber(int number) {

        int lenth = (number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));

        int summ = 0;

        List<Integer> tempArInt = new ArrayList<>();
        if (number > 0){
            for(int a=number; a>0; a/=10)
                tempArInt.add(0, a%10);
        }else tempArInt.add(0);

        for (int i = 0; i < lenth; i++) {
            summ = summ + (int)Math.pow(tempArInt.get(i), lenth);
        }

        return number == summ;
    }

    private static int summAM(int number) {
        boolean test = false;
        int lenth = (number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));

        List<Integer> tempArInt = new ArrayList<>();
        if (number > 0){
            for(int a=number; a>0; a/=10)
                tempArInt.add(0, a%10);
        }else tempArInt.add(0);

        int summ = 0;

        for (int i = 0; i < lenth; i++) {
            summ = summ + (int)Math.pow(tempArInt.get(i), lenth);
        }
        int testPont = 0;
        return summ;
    }

    private static boolean isNumberUnique(int number) {
        int lenth = (number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
        List<Integer> tempArInt = new ArrayList<>();
        if (number > 0){
            for(int a=number; a>0; a/=10)
                tempArInt.add(0, a%10);
        }

        if(lenth == 1) return true;
        else if(lenth == 2) {

            if(tempArInt.get(0) <= tempArInt.get(1)) return true;
        }

        else{ //100
            boolean test = false;

            for (int i = 1; i < lenth-1; i++) {
                if(((tempArInt.get(i)>tempArInt.get(i-1)) &&(tempArInt.get(i)<tempArInt.get(i+1))) || tempArInt.get(lenth-1) == 0)
                    test = true;
                else test = false;
            }
            return test;

        }

        return false;
    }


    public static void main(String[] args) {

        long startDate = new Date().getTime();

        //System.out.println(startDate);

        //146511209
        //9800817 s8
        //9474
        int[] out = getNumbers(1000);
/*
        List<Integer> check = new ArrayList<>();
        for(int a=110; a>0; a/=10)
            check.add(0, a%10);
        System.out.println(check + "!");
*/
/*
        for (long vot: out) {
            System.out.print(vot + " ");
        }
*/

        System.out.println();
        System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024/1024 + " MB");
        System.out.println((new Date().getTime()- startDate) / 1000 + " s.");

    }
}
