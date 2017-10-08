package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

import static javafx.scene.input.KeyCode.W;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileW = new BufferedWriter(new FileWriter(reader.readLine()));

        reader.close();

        while (fileR.ready()) {

            fileW.write(fileR.readLine().replaceAll("[\\W]", ""));

        }


        fileR.close();
        fileW.close();
    }
}
