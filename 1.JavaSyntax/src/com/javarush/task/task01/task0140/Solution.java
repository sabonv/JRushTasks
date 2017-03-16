package com.javarush.task.task01.task0140;

import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        int a;
        //напишите тут ваш код

        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()) {
            a = scan.nextInt();
            System.out.println(a*a);
        }
        else {
            System.out.println("ошибка ввода");
        }


    }
}