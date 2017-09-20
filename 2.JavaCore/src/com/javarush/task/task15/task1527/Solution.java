package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";

        //+ проверка на не пустую строку и наличие занка "?"
        String params = url.substring(url.indexOf('?')+1);

        //System.out.println(params);

        ArrayList<String> obj = new ArrayList();

        while (params.length() > 0){
            String temp = null;
            if (params.contains("&")) {
                temp = params.substring(0, params.indexOf('&'));
                params = params.substring(params.indexOf('&')+1);

                if(temp.contains("obj")) obj.add(temp.substring(temp.indexOf("=")+1));

                if (temp.contains("=")) System.out.print(temp.substring(0,temp.indexOf('=')) + " ");
                else System.out.print(temp + " ");

            }
            else {
                temp = params;
                params = "";
                if (temp.contains("=")) System.out.println(temp.substring(0,temp.indexOf('=')));
                else System.out.println(temp);
            }

        }

        for (String s: obj) {
            try {

                alert( Double.valueOf(s));
            }
            catch (NumberFormatException e){
                alert(s);
            }


        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
