package com.javarush.task.task34.task3404;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        //solution.finder("sin(2*(-5+1.5*4)+28)");
        solution.finder("2+8*(9/4-1.5)^(1+1)");
        //solution.finder("(-2)*(-3)");
        //solution.finder("cos(-30)");
        //solution.finder("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)");
    }

    public void recursion(final String expression, int countOperation) {




        //implement
    }

    public void finder(String str) {

        Map<String, String> allItem = new HashMap<>();
        List<String> tempL = new ArrayList<>();

        String temp = new String();
        temp = str;
        boolean flag = false;
        final Matcher m = Pattern.compile("(\\()(.*)(\\))").matcher(temp);
        final Matcher m2 = Pattern.compile("(\\()(.*)(\\))(.*)(\\()(.*)(\\))").matcher(temp);

            while (m2.find()) {
                //System.out.println(m2.group(2) + " start " + m2.start() + " end " + m2.end());
                flag = true;
                for (int i = 0; i < m2.groupCount() + 1; i++) {
                    if (i%2 ==0){
                        System.out.println(m2.group(i));
                        tempL.add(m2.group(i));
                    }
                }

                System.out.println();

                temp = m2.group(2);
            }
        if(!flag)
        while (m.find()) {
            System.out.println(m.group(2) + " start " + m.start() + " end " + m.end());
            temp = m.group(2);
        }

        if (temp.contains("(") || temp.contains("(")) finder(temp);

    }


    public Solution() {
        //don't delete
    }
}
