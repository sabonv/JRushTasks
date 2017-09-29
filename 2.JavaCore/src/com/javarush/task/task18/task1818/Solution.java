package com.javarush.task.task18.task1818;

/* 
Два в одном
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

        FileOutputStream fileW = new FileOutputStream(files.get(0));
        FileInputStream fileR1 = new FileInputStream(files.get(1));
        FileInputStream fileR2 = new FileInputStream(files.get(2));

        byte[] temp = new byte[fileR1.available()];
        fileR1.read(temp);
        fileW.write(temp);
        fileW.flush();
        fileR1.close();


        temp = new byte[fileR2.available()];
        fileR2.read(temp);
        fileW.write(temp);
        fileR2.close();

        fileW.close();

    }
}
