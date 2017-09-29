package com.javarush.task.task18.task1819;

/* 
Объединение файлов
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
        for (int i = 0; i < 2; i++) {
            files.add(reader.readLine());
        }

        reader.close();

        FileInputStream fileR1 = new FileInputStream(files.get(0));

        byte[] temp = new byte[fileR1.available()];
        fileR1.read(temp);
        fileR1.close();

        FileOutputStream fileW1 = new FileOutputStream(files.get(0));
        FileInputStream fileR2 = new FileInputStream(files.get(1));


        while (fileR2.available()>0){
            fileW1.write(fileR2.read());
        }

        fileW1.write(temp);


        fileR2.close();
        fileW1.close();

    }
}
