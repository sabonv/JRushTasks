package com.javarush.task.task22.task2207;


import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(reader1.readLine()));
        StringBuilder s = new StringBuilder();
        Map<String,String> hashmap = new HashMap<String,String>();
        while (reader.ready())
        {
            s.append(reader.readLine() +" ");
        }
        String[] strings = s.toString().split(" ");
        for (int i = 0; i < strings.length-1; i++)
        {
            for (int j = i+1; j < strings.length; j++)
            {
                if (strings[i].equals(new StringBuilder(strings[j]).reverse().toString()))
                {
                    hashmap.put(strings[i],strings[j]);
                }
            }
        }
        for (Map.Entry<String,String> pair : hashmap.entrySet())
        {
            result.add(new Pair(pair.getKey(),pair.getValue()));
        }
        for (Pair pair: result)
        {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        Pair(String s1, String s2)
        {
            this.first = s1;
            this.second = s2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
