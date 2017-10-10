package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        if(args.length>0){

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while (fileR.ready()){
                 outputStream.write(fileR.read());
            }

            System.out.println(outputStream.toString().replace("\r\n", ""));

        }

    }
}
