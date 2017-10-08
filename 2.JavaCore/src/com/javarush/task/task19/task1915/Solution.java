package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileW = new FileOutputStream(reader.readLine());
        reader.close();
        PrintStream trueStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();

        String result = outputStream.toString();
        char[] resCh = result.toCharArray();
        for (char ch: resCh) {
            fileW.write(ch);
        }


        fileW.close();
        //Возвращаем все как было
        System.setOut(trueStream);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

