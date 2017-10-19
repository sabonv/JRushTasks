package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");

    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0, jx = a[0].length;
        boolean openR = false;

        while(getSum(a) > 0){

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {

                    if(a[i][j] == 1 && !openR){
                        count++;
                        jx = j;
                        openR = true;
                        a[i][j] = 0;
                    }
                    else if(a[i][j] == 1 && openR) a[i][j] = 0;
                    else if(a[i][j] == 0 && openR && j == jx){
                        i = a.length;
                        j = a[0].length;
                        break;
                    }
                    else if(a[i][j] == 0 && openR && j > jx){
                        break;
                    }
                }
            }

            openR = false;

        }

        return count;
    }

    public static int getSum(byte[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum = sum + a[i][j];
            }
        }

        return sum;
    }

}
