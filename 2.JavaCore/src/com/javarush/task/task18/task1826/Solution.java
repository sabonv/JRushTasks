package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{

        String key = "", fileIn = "", fileOut = "";

        if(!args[0].equals("") || !args[0].equals(null)) key = args[0];
        if(!args[1].equals("") || !args[1].equals(null)) fileIn = args[1];
        if(!args[2].equals("") || !args[2].equals(null)) fileOut = args[2];

        FileInputStream fileR = new FileInputStream(fileIn);
        FileOutputStream fileW = new FileOutputStream(fileOut);


        if(key.equals("-e") && !key.equals("")) {
            int temp;

            while (fileR.available() > 0){
                temp = fileR.read();
                fileW.write(temp + 2);
            }
            fileR.close();
            fileW.close();
        }
        else if(key.equals("-d") && !key.equals("")) {
            int temp;

            while (fileR.available() > 0){
                temp = fileR.read();
                fileW.write(temp - 2);
            }
            fileR.close();
            fileW.close();
        }

    }

}
