package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> files = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            files.add(reader.readLine());
        }

        reader.close();

        FileInputStream fileR1 = new FileInputStream(files.get(0));
        FileOutputStream fileW2 = new FileOutputStream(files.get(1));

        byte[] tempB = new byte[fileR1.available()];


        fileR1.read(tempB);
        fileR1.close();

        String tempS = "";

        List<Double> tempLD = new ArrayList<>();

        for (int i = 0; i <= tempB.length; i++) {

            if (i == tempB.length) tempLD.add(Double.parseDouble(tempS));
            else {

                if (tempB[i] != 32) {
                    tempS = tempS + String.valueOf((char) tempB[i]);
                } else {
                    tempLD.add(Double.parseDouble(tempS));
                    tempS = "";
                }

            }
        }

        //System.out.println(tempLD);

        String result = "";

        for (Double b: tempLD) {
            result = result + Math.round(b) + " ";
        }
        //System.out.println(result);

        char[] chars = result.toCharArray();
        for (char ch: chars) {
            fileW2.write((byte)ch);
        }

        fileW2.close();

    }
}
