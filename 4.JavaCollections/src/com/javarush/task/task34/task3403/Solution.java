package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {

        int count = 2;
        if (n==1) return;
        while (n%count != 0) {
            count++;
        }

        System.out.print(count +" ");

        recursion(n/count);

    }

}
