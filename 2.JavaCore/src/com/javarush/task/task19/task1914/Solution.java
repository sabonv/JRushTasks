package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream trueStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        //3 + 6 = 9
        String result = outputStream.toString().replaceAll("\r", "").replaceAll("\n", "");

        String[] resL = result.split(" ");
        int a =0, b=0, c=0;
        try {
            a = Integer.parseInt(resL[0]);
            b = Integer.parseInt(resL[2]);

        }catch (Exception e) {

        }

        switch (resL[1]) {
            case ("+") :{
                c = a + b;
                break;
            }
            case ("-") : {
                c = a - b;
                break;
            }
            case ("*") : {
                c = a * b;
                break;
            }
        }

        //Возвращаем все как было
        System.setOut(trueStream);
        System.out.print(result + String.valueOf(c));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

