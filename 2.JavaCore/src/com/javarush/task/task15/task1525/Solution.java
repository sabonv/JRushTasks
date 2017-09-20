package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileInputStream file = new FileInputStream(Statics.FILE_NAME);

            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            String s;
            while ((s = reader.readLine()) != null){
                lines.add(s);
            }

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }




    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
