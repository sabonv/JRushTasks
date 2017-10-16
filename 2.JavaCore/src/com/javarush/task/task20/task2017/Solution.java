package com.javarush.task.task20.task2017;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object test = objectStream.readObject();
            if(test instanceof A) return (A)test;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
