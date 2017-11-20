package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution{

    //public static ThreadLocalRandom tlr = ThreadLocalRandom.current();

    public static int getRandomIntegerBetweenNumbers(int from, int to) {

        return (int)ThreadLocalRandom.current().nextDouble(from, to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble(1);
    }

    public static long getRandomLongBetween0AndN(long n) {
        return (long)ThreadLocalRandom.current().nextDouble(n);
    }



    public static void main(String[] args) {
    }
}
