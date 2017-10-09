package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileR = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        int count = 0;
        while (fileR.ready()) {

            String str = fileR.readLine();
            String[] strArr = str.split(" ");
            for (String word: strArr) {
                for (String mask: words) {
                    if(mask.equals(word)) count++;
                }
            }
            if(count == 2) System.out.println(str);
            count = 0;
        }
        fileR.close();
    }
}
