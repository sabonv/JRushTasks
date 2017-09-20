package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

    public  int intVar;
    public  double doubleVar;
    public  Double DoubleVar;
    public  boolean booleanVar;
    public  Object ObjectVar;
    public  Exception ExceptionVar;
    public  String StringVar;


    public static void main(String[] args) {

        Solution so = new Solution();

        System.out.println(so.intVar);
        System.out.println(so.doubleVar);
        System.out.println(so.DoubleVar);
        System.out.println(so.booleanVar);
        System.out.println(so.ObjectVar);
        System.out.println(so.ExceptionVar);
        System.out.println(so.StringVar);

    }
}
