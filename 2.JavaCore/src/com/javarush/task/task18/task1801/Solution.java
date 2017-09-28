package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream readerF = new FileInputStream(reader.readLine());
        reader.close();
        //BufferedReader readerF = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        int max = 0;
        int temp;
        while (readerF.available() > 0){
            temp = readerF.read();
            if (temp > max) max = temp;

        }
        readerF.close();
        System.out.println(max);

//        byte[] buffer = new byte[readerF.available()];
//        readerF.read(buffer, 0, readerF.available());
//        readerF.close();
//
//        byte max = buffer[0];
//        for (int i = 1; i < buffer.length; i++) {
//            if (buffer[i]>max) max = buffer[i];
//
//        }
//        System.out.println(max);

    }
}
