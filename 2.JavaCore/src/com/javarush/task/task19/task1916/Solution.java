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

        FileReader file1 = new FileReader(reader.readLine());
        FileReader file2 = new FileReader(reader.readLine());
        BufferedReader fileR1 = new BufferedReader(file1);
        BufferedReader fileR2 = new BufferedReader(file2);


        reader.close();

        while (fileR1.ready()) {
            String temp1 = fileR1.readLine();
            String temp2 = fileR2.readLine();
            if (temp1.equals(temp2)) {
                lines.add(new LineItem(Type.SAME, temp1));
            }
            else if(temp1==null || temp1.equals("")) {
                lines.add(new LineItem(Type.ADDED, temp2));
            }
            else if(temp2==null || temp2.equals("")) {
                lines.add(new LineItem(Type.REMOVED, temp1));
            }
        }
        fileR1.close();
        fileR2.close();
        file1.close();
        file2.close();


//        for (LineItem pair: lines) {
//            System.out.println(pair.type +" "+ pair.line);
//        }
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
