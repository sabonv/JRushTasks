package com.javarush.task.task18.task1809;

/* 
Реверс файла
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

        FileInputStream fileR = new FileInputStream(files.get(0));
        FileOutputStream fileW1 = new FileOutputStream(files.get(1));

        byte[] temp = new byte[fileR.available()];
        fileR.read(temp);
        fileR.close();

        for (int i = temp.length-1; i >= 0; i--) {
            fileW1.write(temp[i]);
            System.out.print(temp[i] + " ");

        }
        fileW1.close();
    }

}
