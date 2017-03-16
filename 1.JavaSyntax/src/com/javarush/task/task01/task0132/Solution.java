package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код

        String nums = Integer.toString(number);
        char[] numc = nums.toCharArray();
        int sum =0;
        for (int i = 0; i < numc.length; i++) {
           sum = sum + Integer.parseInt(Character.toString(numc[i])) ;
        }
        System.out.println("chr summ " + sum);
        return number/100 + (number % 100)/10 + (number % 100)%10 ;
    }
}