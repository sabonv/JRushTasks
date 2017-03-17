package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> book = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            book.add(Integer.parseInt(read.readLine()));
        }

        int temp = book.get(0), count = 1, countm = 0;

        for (int i = 1; i < book.size(); i++) {
            if (temp == book.get(i)) count++;
            else {
                temp = book.get(i);
                if (countm < count) countm = count;
                count = 1;
            }
        }
        if (countm < count) countm = count;
        System.out.println(countm);

    }
}