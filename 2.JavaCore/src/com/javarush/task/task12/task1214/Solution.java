package com.javarush.task.task12.task1214;

/* 
Корова — тоже животное
*/

import com.sun.org.apache.xerces.internal.util.SymbolTable;

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow extends Animal{

        public String getName(){
            return "test";
        };

    }

}
