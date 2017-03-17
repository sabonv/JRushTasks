package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

public class Solution {
    public static void main(String[] args) throws Exception {


        try {
            throw new MyException();
//            throw new MyException2();
//            throw new MyException3();
//            throw new MyException4();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }
    
    static class MyException extends Exception {
    }

    static class MyException2 extends MyException{
    }

    static class MyException3 extends RuntimeException {
    }

    static class MyException4 extends MyException3{
    }
}

