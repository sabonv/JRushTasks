package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileW = new BufferedWriter(new FileWriter(reader.readLine()));

        reader.close();

        while (fileR.ready()) {

            fileW.write(fileR.readLine().replace('.', '!'));

        }
        fileR.close();
        fileW.close();
    }
}
