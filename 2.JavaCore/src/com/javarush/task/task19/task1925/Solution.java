package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {

        if(args.length == 2) {
            BufferedReader fileR = new BufferedReader(new FileReader(args[0]));
            BufferedWriter fileW = new BufferedWriter(new FileWriter(args[1]));
            int count = 0;
            while (fileR.ready()) {
                String line = fileR.readLine();
                String[] tempArr = line.split(" ");

                for (String str: tempArr) {
                    if(str.length()>6) {
                        count++;
                        if(count!=1) fileW.write("," + str);
                        else fileW.write(str);
                    }
                }

            }
            fileR.close();
            fileW.close();
        }

    }
}
