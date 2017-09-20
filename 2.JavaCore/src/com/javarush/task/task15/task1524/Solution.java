package com.javarush.task.task15.task1524;

/* 
Порядок загрузки переменных
*/

public class Solution {

//1
    static {
        init();
    }

    public static void init() {
        System.out.println("static void init()");
    }

//2
    static {
        System.out.println("Static block");
    }

//4
    {
        System.out.println("non-static block");
        printAllFields(this);
    }
//6
    public int i = 6;

    public String name = "First name";


//7
    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }


//3
    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }

//5//8
    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);
    }
}
