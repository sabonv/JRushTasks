package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while (fileR.ready()) {

            System.out.println(new StringBuffer(fileR.readLine()).reverse());

        }
        fileR.close();
    }
}
