package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.BinaryOperator;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        try{

            for (int i = 2; i < 37; i++) {

                if (test(args[0], i)) {
                    System.out.println(i);
                    break;
                }

                else if (i == 36) System.out.println("incorrect");
            }


        }catch (Exception e) {

        }

    }


    private static boolean test(String str, int rad) {
        boolean flag = false;
        try {

            new BigDecimal(new BigInteger(str,rad));
            return true;

        }catch (Exception e) {

        }


        return flag;
    }


}