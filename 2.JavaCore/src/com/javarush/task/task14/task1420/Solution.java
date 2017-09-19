package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b;

            a = Integer.parseInt(reader.readLine());
            if( a <= 0 ) throw new NullPointerException("A - кривое " + a);
            b = Integer.parseInt(reader.readLine());
            if( b <= 0 ) throw new NullPointerException("Б - кривое " + b);


        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }


        System.out.println(a);

    }


}

