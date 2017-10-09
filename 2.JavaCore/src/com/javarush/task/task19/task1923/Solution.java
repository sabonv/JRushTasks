package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception{

        if(args.length == 2) {

            BufferedReader fileR = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileW = new BufferedWriter(new FileWriter(args[1]));

            while (fileR.ready()) {

                String str = fileR.readLine();
                String[] strArr = str.split(" ");

                for (String strTemp: strArr) {
                    if(strTemp.matches(".*[0-9]+.*") || strTemp.matches("[0-9]+.*[0-9]+")) {
                        fileW.write(strTemp + " ");
                        fileW.flush();
                        //System.out.print(strTemp + " ");
                    }
                }

            }
            fileR.close();
            fileW.close();
        }

    }
}
