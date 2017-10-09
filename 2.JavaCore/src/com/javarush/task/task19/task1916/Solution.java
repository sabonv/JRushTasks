package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        BufferedReader fileR1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fileR2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (fileR1.ready()) list1.add(fileR1.readLine());
        while (fileR2.ready()) list2.add(fileR2.readLine());
        fileR1.close();
        fileR2.close();


//        while (list1.size() > 0 || list2.size() > 0) {
//
//            if((list2.size() > 1) && (list1.get(0).equals(list2.get(1)))) {
//                lines.add(new LineItem(Type.ADDED, list2.remove(0)));
//                lines.add(new LineItem(Type.SAME, list1.remove(0)));
//
//                list2.remove(0);
//            }
//            else if((list1.size() > 1) && (list1.get(1).equals(list2.get(0)))) {
//                lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
//                lines.add(new LineItem(Type.SAME, list1.remove(0)));
//                list2.remove(0);
//            }
//
//            else             if((list2.size() > 0) && (list1.get(0).equals(list2.get(0)))) {
//                lines.add(new LineItem(Type.SAME, list1.remove(0)));
//                list2.remove(0);
//
//            }
//
//            else if((list1.size() > 0) && (list2.size() == 0)) {
//                lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
//            }
//            else if((list2.size() > 0) && (list1.size() == 0)) {
//                lines.add(new LineItem(Type.ADDED, list2.remove(0)));
//            }
//
//
//        }


        while (list1.size() > 0 | list2.size() > 0) {
            if (list1.size() > 0 && list2.size() > 0) {

                if (list1.get(0).equals(list2.get(0))) {
                    lines.add(new LineItem(Type.SAME, list1.get(0)));
                    list1.remove(0);
                    list2.remove(0);
                } else if (!list1.get(0).equals(list2.get(0)) && !list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                } else if (!list1.get(0).equals(list2.get(0)) && list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                }
            } else if (list1.size() > 0 && list2.isEmpty()) {
                for (int i = 0; i < list1.size(); i++) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    list1.remove(0);
                }
            } else if (list1.isEmpty() && list2.size() > 0) {
                for (int i = 0; i < list2.size(); i++) {
                    lines.add(new LineItem(Type.ADDED, list2.get(i)));
                    list2.remove(0);
                }
            }
        }

        for (LineItem pair: lines) {
            System.out.println(pair.type +" "+ pair.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
