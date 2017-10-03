package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name;
        List<String> names = new ArrayList<>();

        while(true){
            name = reader.readLine();

            try {
                FileInputStream file = new FileInputStream(name);
                file.close();
            }
            catch (FileNotFoundException e){
                System.out.println(name);

                break;
            }

        }

    }
}
