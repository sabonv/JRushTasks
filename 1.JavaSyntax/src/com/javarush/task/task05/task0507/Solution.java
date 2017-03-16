package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int summ = 0, count = 0, i = 0;
        boolean f = true;

        while (f) {

            i = Integer.parseInt(read.readLine());
            if (i != -1) {
                summ =summ + i;
                count++;
            }
            else f = false;
        }
        System.out.println((double)summ/count);



/*        String vvod = read.readLine();

        char[] vvodc = vvod.toCharArray();
        String strt = new String();
        int summ = 0;
        int count = 0;



        for (int i = 0; i < vvodc.length; i++) {
            if ((vvodc[i] >= 48 && vvodc[i] <= 57) || (vvodc[i] == 45) ) {
                strt = strt + Character.toString(vvodc[i]);
            }
            else if (!strt.equals("-1")){
                if (!strt.equals(null)) {
                    summ = summ + Integer.parseInt(strt);
                    count++;
                }
                strt = "";
            }
            if (strt.equals("-1")) {
                System.out.println((double)summ/count);
            }

        }*/

    }
}

