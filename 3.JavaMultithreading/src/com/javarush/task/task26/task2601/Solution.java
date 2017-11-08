package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

//        Integer[] test = new Integer[]{1, 9,3,4,5,11,7,8,2,10,6};
//        for (Integer num: sort(test)) {
//
//            System.out.print(num + ", ");
//
//        }

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int len = array.length;
        int mediana = len % 2 != 0 ? array[len / 2] : (int)((array[len / 2] + array[len / 2 - 1]) / 2);

        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
            }
        };

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list, comp);
        Integer[] rez = list.toArray(new Integer[list.size()]);
        return rez;
    };
}
