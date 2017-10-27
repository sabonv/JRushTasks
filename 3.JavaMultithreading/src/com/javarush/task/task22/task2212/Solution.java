package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null || telNumber.length() < 10) return false;
        Matcher m;
        Pattern p;

//        p = Pattern.compile("^\\+[0-9]{12}$");
//        m = p.matcher(telNumber);
//        if(m.find()) return true;

//        p = Pattern.compile("^\\+[0-9]{2}\\([0-9]{3}\\)&([0-9]{7})|([0-9]{3}[-]?[0-9]{2}[-]?[0-9]{2})$");
//        m = p.matcher(telNumber);
//        if(m.find()) return true;

        p = Pattern.compile("^(\\+[0-9]{2})?((\\()?[0-9]{3}(\\))?)(([0-9]{3}[\\-][0-9]{2}[\\-]?[0-9]{2})|([0-9]{7}))$");
        m = p.matcher(telNumber);
        if(m.find()) return true;

        //|([[0-9]+[\-]{1}[0-9]+]{8})|([0-9]{7})


//        p = Pattern.compile("^((([0-9]{3}[\\-][0-9]{2}[\\-]?[0-9]{2})))$");
//        m = p.matcher(telNumber);
//        if(m.find()) return true;

        else System.out.println("NEt");

        return false;
    }

    public static void main(String[] args) {

       //if(checkTelNumber("112-44-11")) System.out.println("DA");
       if(checkTelNumber("+38(050)1234367")) System.out.println("DA");
//       if(checkTelNumber("+380501234567")) System.out.println("DA");
//       if(checkTelNumber("+38(050)1234567")) System.out.println("DA");
//       if(checkTelNumber("+38(050)123-45-67")) System.out.println("DA");
//       if(checkTelNumber("050123-4567")) System.out.println("DA");
       if(checkTelNumber("0501234567")) System.out.println("DA");


    }
}
