package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException{

        FileInputStream file = new FileInputStream(args[0]);
        int countS = 0, countL = 0;

        //32
        while (file.available()>0){
            int temp;
            temp = file.read();
            countL++;
            if (temp == 32) countS++;
        }

        file.close();

        //int countS = 9, countL = 52;
        double result =((double)countS/countL)*100;

        System.out.println(String.format("%.2f",result));


    }
}
