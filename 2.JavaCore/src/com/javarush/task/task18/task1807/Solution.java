package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readerF = new FileInputStream(reader.readLine());
        reader.close();


        int count = 0;
        int temp;
        while (readerF.available() > 0){
            temp = readerF.read();
            if((char)temp == ',') count++;
        }
        readerF.close();

        System.out.println(count);
    }
}
