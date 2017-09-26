package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут


        if(args[0].equals("-c")) {
            create(args);
        }
        else if(args[0].equals("-u")) {
            update(args);
        }
        else if(args[0].equals("-d")) {

            delete(args);
        }
        else if(args[0].equals("-i")) {
            info(args);
        }


    }

//    public static void printP(int id) {
//
//        System.out.println("Name - " + allPeople.get(id).getName() + ", Sex - " + allPeople.get(id).getSex() + ", BirthDay - " + allPeople.get(id).getBirthDay());
//
//    }

    public static void info(String[] args){
        int id = Integer.parseInt(args[1]);

        if(allPeople.size() > id && allPeople.get(id) != null){

            String sex;
            if(allPeople.get(id).getSex() == Sex.MALE) sex = "м";
            else sex = "ж";

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            System.out.println(allPeople.get(id).getName() + " " + sex + " " + dateFormat.format(allPeople.get(id).getBirthDay()));
        }

    }

    public static void delete(String[] args){

        int id = Integer.parseInt(args[1]);

        if(allPeople.size() > id && allPeople.get(id) != null){

            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);

        }

    }

    public static void update(String[] args){

        int id = Integer.parseInt(args[1]);

        if(allPeople.size() > id && allPeople.get(id) != null){

            String name = args[2];
            int sexId = 3, dateId = 4;

            if (!args[3].equals("ж") && !args[3].equals("м")) {
                name = name + " " + args[3];
                sexId++;
                dateId++;
            }
            allPeople.get(id).setName(name);

            if(args[sexId].equals("м")) allPeople.get(id).setSex(Sex.MALE);
            else allPeople.get(id).setSex(Sex.FEMALE);

            Date dateB = null;
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd/MM/yyyy");
            try {
                dateB = format.parse(args[dateId]);
            }
            catch (ParseException e){
                System.out.println(e.getMessage());
            }

            allPeople.get(id).setBirthDay(dateB);

        }

    }

    public static void create(String[] args){

        int id = allPeople.size();

        String name = args[1];
        int sexId = 2, dateId = 3;

        if (!args[2].equals("ж") && !args[2].equals("м")) {
            name = name + " " + args[2];
            sexId++;
            dateId++;
        }


        Date dateB = null;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd/MM/yyyy");
        try {
            dateB = format.parse(args[dateId]);
        }
        catch (ParseException e){
            System.out.println(e.getMessage());
        }

        if(args[sexId].equals("м")) allPeople.add(Person.createMale(name, dateB));
        else allPeople.add(Person.createFemale(name, dateB));

        System.out.println(id);


    }

}
