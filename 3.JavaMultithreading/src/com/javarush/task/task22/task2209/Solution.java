package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...


        String strIn = "";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileR = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        )
        {
            while (fileR.ready()) {
                strIn = strIn + fileR.readLine();
            }
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[] strArr = strIn.split(" ");

//        for (String str: strArr) {
//            System.out.print(str + " ");
//        }

        StringBuilder result = getLine(strArr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result;
        if (words.length==1 || words[0].equals("")) return result.append(words[0]);

        ArrayList<String> wordsList = new ArrayList<>();

        wordsList.addAll(Arrays.asList(words));
        while (wordsList.remove("")){
            wordsList.remove("");
        }
        while (isYes(wordsList)) {
            for (String str : wordsList) {
                System.out.print(str + " ");
            }
            System.out.println("");
            Collections.shuffle(wordsList);
        }
        for (String word: wordsList){

            result.append(word).append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result;
    }

    public static boolean isYes(ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            String firstWord = wordsList.get(i).toLowerCase();
            String secondWord = wordsList.get(i + 1).toLowerCase();
            if (firstWord.charAt(firstWord.length() - 1) != secondWord.charAt(0)) return true;
        }
        return false;
    }
}
