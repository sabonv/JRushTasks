package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m, int n, String value) {
        System.out.println("3");
    }

    public static void printMatrix(Integer m, Integer n, String value) {
        System.out.println("4");
    }

    public static void printMatrix(int m, Integer n, String value) {
        System.out.println("5");
    }
    public static void printMatrix(long m, Integer n, String value) {
        System.out.println("6");
    }

    public static void printMatrix(long m, int n, String value) {
        System.out.println("7");
    }

    public static void printMatrix(Integer m, long n, String value) {
        System.out.println("8");
    }

    public static void printMatrix(short m, int n, String value) {
        System.out.println("9");
    }

    public static void printMatrix(long m, int n, Object value) {
        System.out.println("10");
    }



}
