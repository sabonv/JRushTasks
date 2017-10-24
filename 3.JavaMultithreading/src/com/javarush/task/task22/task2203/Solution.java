package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{

        if (string == null || string.isEmpty()) throw new TooShortStringException();

        int count =0, stop = 0, start = 0;
        String temp = string;

        Pattern pattern = Pattern.compile("\t");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()){
            count++;
        }

        if(count<2) throw new TooShortStringException();
        try {
            start = string.indexOf("\t") + 1;

            for (int i = 0; i < 2; i++) {
                temp = temp.substring((temp.indexOf("\t") + 1));
            }
            stop = string.lastIndexOf(temp) - 1;

        } catch (Exception e) {
            throw new TooShortStringException();
        }



        return string.substring(start, stop);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
