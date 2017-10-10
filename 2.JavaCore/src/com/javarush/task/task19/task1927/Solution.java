package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
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

        String[] streamArr = outputStream.toString().split(System.lineSeparator());
        System.setOut(trueStream);

        for (int i = 0; i < streamArr.length; i++) {
            if(i%2 == 0){
                System.out.println(streamArr[i]);
            }
            else {
                System.out.println(streamArr[i]);
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

        //String result = outputStream.toString();

        //Возвращаем все как было
        //System.setOut(trueStream);
        //System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
