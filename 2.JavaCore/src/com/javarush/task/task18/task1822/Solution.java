package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //FileInputStream fileR = new FileInputStream(reader.readLine());


        BufferedReader readerF = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        String tempStr = "";

        while ((tempStr = readerF.readLine()) != null) {
            String[] arrStr = tempStr.split(" ");
            if(arrStr[0].equals(args[0])) System.out.println(tempStr);

        }

        reader.close();
        readerF.close();
//        Map<String, String> map = new HashMap<>();
//
//        String key = "", val = "";
//        while (fileR.available() > 0){
//            char temp;
//
//            if (!((temp = (char)fileR.read()) == ' ')) {
//                if(temp != '\n')
//                key = key + String.valueOf(temp);
//            }
//            else {
//                while ((fileR.available() > 0) && !((temp = (char)fileR.read()) == '\r')){
//
//                    val = val + String.valueOf(temp);
//                    map.put(key, val);
//                    //key = "";
//                    //val = "";
//                }
//                if(temp == '\r') {
//                    key = "";
//                    val = "";
//                }
//
//            }
//
//        }
//
//        fileR.close();
//
//        System.out.println(map.get(args[0]));

    }
}
