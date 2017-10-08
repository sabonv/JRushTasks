package com.javarush.task.task19.task1908;

/*
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileW = new BufferedWriter(new FileWriter(reader.readLine()));

        reader.close();

        String[] tempAS;
        List<String> resultL = new ArrayList<>();

        while (fileR.ready()) {
            int tempI;
            tempAS = fileR.readLine().split(" ");
            for (String str: tempAS) {

                try {
                    tempI = Integer.parseInt(str);
                    resultL.add(str);

                } catch (Exception e) {

                }

            }
        }

        fileR.close();

        for (String str: resultL) {
            fileW.write(str + " ");
        }

        fileW.close();


    }
}
