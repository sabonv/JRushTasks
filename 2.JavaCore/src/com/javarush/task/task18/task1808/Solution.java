package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> files = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            files.add(reader.readLine());
        }

        reader.close();

        FileInputStream fileR = new FileInputStream(files.get(0));
        FileOutputStream fileW1 = new FileOutputStream(files.get(1));
        FileOutputStream fileW2 = new FileOutputStream(files.get(2));



        int part1;
        if(fileR.available()%2 != 0) {
            part1 = (fileR.available() / 2) + 1;
        }
        else {
            part1 = fileR.available()/2;
        }

        byte[] temp = new byte[part1];
        fileR.read(temp, 0, part1);
        fileW1.write(temp);
        fileW1.close();

        temp = new byte[fileR.available()];
        fileR.read(temp, 0, fileR.available());
        fileW2.write(temp);
        fileW2.close();

        fileR.close();

    }

}
