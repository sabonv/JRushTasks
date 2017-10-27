package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if(args[0].length() != 0 && args[1].length() != 0) {

            try (FileInputStream fileR = new FileInputStream(args[0]);
                 FileOutputStream fileW = new FileOutputStream(args[1]);
                 InputStreamReader in = new InputStreamReader(fileR, "windows-1251");
                 OutputStreamWriter out = new OutputStreamWriter(fileW, "UTF-8")
            )
            {
                while (in.ready()) {

                    out.write(in.read());

                }
           } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
