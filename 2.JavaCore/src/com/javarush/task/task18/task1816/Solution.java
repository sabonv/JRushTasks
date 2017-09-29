package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/


import java.io.FileInputStream;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{

        FileInputStream file = new FileInputStream(args[0]);
        int count = 0;

        //65-90, 97-122
        while (file.available()>0){
            int temp;
            temp = file.read();
            if (((temp>=65) && (temp<=90)) || ((temp>=97) && (temp<=122))) count++;

        }
        file.close();
        System.out.println(count);

    }
}
