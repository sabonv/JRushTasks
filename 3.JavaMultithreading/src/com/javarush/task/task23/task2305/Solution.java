package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }



    public static Solution[] getTwoSolutions() {

        Solution[] solAll = new Solution[2];

        Solution sol1 = new Solution();
        sol1.innerClasses[0] = sol1.new InnerClass();
        sol1.innerClasses[1] = sol1.new InnerClass();
        solAll[0] = sol1;
        Solution sol2 = new Solution();
        sol2.innerClasses[0] = sol2.new InnerClass();
        sol2.innerClasses[1] = sol2.new InnerClass();
        solAll[1] = sol2;

        return solAll;
    }

    public static void main(String[] args) {

    }
}
