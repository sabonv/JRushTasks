package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{

        if(args.length != 0) {
            BufferedReader fileR = new BufferedReader(new FileReader(args[0]));
            String[] temp;
            String name = "", date = "";
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");

            while (fileR.ready()) {

                temp = fileR.readLine().split(" ");
                for (int i = 0; i < temp.length-3; i++) {
                    name = name + temp[i] + " ";
                }
                date = temp[temp.length-3] + "." + temp[temp.length-2] + "." + temp[temp.length-1];


                PEOPLE.add(new Person(name.substring(0, name.length()-1), format.parse(date)));
                name = "";
                date = "";

            }
            fileR.close();

            for (Person pers: PEOPLE) {
                System.out.println(pers.getName() + ": " + pers.getBirthday());
            }
        }
    }
}
