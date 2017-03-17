package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> book = new ArrayList<>();

        int maxl = 0, minl = 0, maxi = 0, mini = 0;



        for (int i = 0; i < 10; i++) {
            book.add(i, read.readLine());
            if (book.get(i).length() > maxl){
                maxl = book.get(i).length();
                maxi=i;
            }
        }
        minl = maxl;
        for (int i = 0; i < 10; i++) {

            if (book.get(i).length() < minl) {
                minl = book.get(i).length();
                mini = i;
            }
        }

        if (maxi < mini) System.out.println(book.get(maxi));
        else System.out.println(book.get(mini));

    }
}
