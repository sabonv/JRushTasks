package com.javarush.task.task22.task2202;



/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        //System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("12227 8 9"));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        int start=0, stop=0, count=0;
        String temp = string;

        for (Character charB: string.toCharArray()) {
            if(charB==' ') count++;
        }

        if(count < 4) throw new TooShortStringException();


            try {
                start = string.indexOf(" ") + 1;
                for (int i = 0; i < 5; i++) {
                    temp = temp.substring((temp.indexOf(" ") + 1));
                }
                stop = string.lastIndexOf(temp) - 1;


            } catch (StringIndexOutOfBoundsException e) {
                throw new TooShortStringException();
            }

        if(count==4) stop= string.length();

            return string.substring(start, stop);
    }

    public static class TooShortStringException extends RuntimeException{

    }
}
