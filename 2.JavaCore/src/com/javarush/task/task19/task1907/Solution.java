package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileR = new FileReader(reader.readLine());

        reader.close();
        int count = 0, tempI ;
        String tempS = "";

        while (fileR.ready()) {

            tempI = fileR.read();

            if((tempI > 64 && tempI < 91) || (tempI > 96 && tempI < 123)){
                tempS = tempS + String.valueOf(Character.toChars(tempI));
            }
            else {
                if(tempS.equals("world")) count++;
                tempS = "";
            }

        }

        if(tempS.equals("world")) count++;

        fileR.close();
        System.out.println(count);

    }
}
