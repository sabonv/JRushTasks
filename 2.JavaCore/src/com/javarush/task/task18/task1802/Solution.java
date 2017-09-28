package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readerF = new FileInputStream(reader.readLine());
        reader.close();

        int min = readerF.read();
        int temp;
        while (readerF.available() > 0){
            temp = readerF.read();
            if (temp < min) min = temp;

        }
        readerF.close();
        System.out.println(min);

    }
}
