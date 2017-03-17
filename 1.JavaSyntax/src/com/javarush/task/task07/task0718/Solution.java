package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> book = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            book.add(read.readLine());
        }
        for (int i = 1; i < book.size(); i++) {

            if (book.get(i-1).length() < book.get(i).length()){

            }
            else  {
                System.out.println(i);
                break;
            }
        }



    }
}

