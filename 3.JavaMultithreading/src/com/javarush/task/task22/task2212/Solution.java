package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        Matcher m;
        Pattern p;

        p = Pattern.compile("^\\+[0-9]{12}$");
        m = p.matcher(telNumber);
        if(m.find()) return true;

        p = Pattern.compile("^\\+[0-9]{2}\\([0-9]{3}\\)[0-9]{7}$");
        m = p.matcher(telNumber);
        if(m.find()) return true;



        else System.out.println("NEt");

        return false;
    }

    public static void main(String[] args) {


       if(checkTelNumber("+380501234567")) System.out.println("DA");
       if(checkTelNumber("+38(050)1234567")) System.out.println("DA");


    }
}
