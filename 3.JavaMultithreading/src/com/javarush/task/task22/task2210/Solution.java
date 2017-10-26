package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

//        for (String str: getTokens("level22.lesson13.task01", ".")) {
//            System.out.println(str);
//        }


    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        String[] strArr = new  String[tokenizer.countTokens()];
        int count = 0;
        while (tokenizer.hasMoreTokens()) {

            strArr[count++] = tokenizer.nextToken();

        }

        return strArr;
    }
}
