package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = read.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {

            int temp = Integer.parseInt(Character.toString(arr[i]));
            if (temp%2 != 0) odd++;
            else even++;

        }
        System.out.println("Even: "+ even + " Odd: " + odd);

    }
}
