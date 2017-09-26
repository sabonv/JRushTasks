package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if(args.length > 1) {

            switch (args[0]){

                case "-c": {

                    Pattern p = Pattern.compile("^[0-9][0-9][/][0-9][0-9][/][0-9][0-9][0-9][0-9]$");
                    String[] temp = {"", "", ""};
                    List<String[]> list = new ArrayList<>();
                    for (int i = args.length - 1; i > 1; i--) {

                        if(p.matcher(args[i]).matches() && (p.matcher(args[i-3]).matches() || args[i-3].equals("-c"))) {
                            temp[0] = args[i-2];
                            temp[1] = args[i-1];
                            temp[2] = args[i];
                            i = i-2;
                            list.add(temp.clone());

                        }
                        else if(p.matcher(args[i]).matches() && (p.matcher(args[i-4]).matches() || args[i-4].equals("-c"))) {
                            temp[0] = args[i-3] + " " + args[i-2];
                            temp[1] = args[i-1];
                            temp[2] = args[i];
                            i = i-3;
                            list.add(temp.clone());

                        }

                    }

                    synchronized (allPeople){

                        for (int i = list.size()-1; i >= 0 ; i--) {
                            create(list.get(i));
                        }

                    }
                    break;
                }
                case "-u": {

                    Pattern p = Pattern.compile("^[0-9][0-9][/][0-9][0-9][/][0-9][0-9][0-9][0-9]$");
                    String[] temp = {"", "", "", ""};
                    List<String[]> list = new ArrayList<>();
                    for (int i = args.length - 1; i > 1; i--) {

                        if(p.matcher(args[i]).matches() && (p.matcher(args[i-4]).matches() || args[i-4].equals("-u"))) {
                            temp[0] = args[i-3];
                            temp[1] = args[i-2];
                            temp[2] = args[i-1];
                            temp[3] = args[i];
                            i = i-3;
                            list.add(temp.clone());

                        }
                        else if(p.matcher(args[i]).matches() && (p.matcher(args[i-5]).matches() || args[i-5].equals("-u"))) {
                            temp[0] = args[i-4];
                            temp[1] = args[i-3] + " " + args[i-2];
                            temp[2] = args[i-1];
                            temp[3] = args[i];
                            i = i-4;
                            list.add(temp.clone());

                        }

                    }

                    synchronized (allPeople){

                        for (int i = list.size()-1; i >= 0 ; i--) {
                            update(list.get(i));
                        }

                    }
                    break;

                }
                case "-d":{
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            delete(Integer.parseInt(args[i]));
                        }
                    }
                    break;
                }
                case "-i":{

                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            info(Integer.parseInt(args[i]));
                        }
                    }
                    break;
                }

            }

        }

    }

//    public static void printP(int id) {
//
//        System.out.println("Name - " + allPeople.get(id).getName() + ", Sex - " + allPeople.get(id).getSex() + ", BirthDay - " + allPeople.get(id).getBirthDay());
//
//    }

    public static void info(int id){
        //int id = Integer.parseInt(args[1]);

        if(allPeople.size() > id && allPeople.get(id) != null){

            String sex;
            if(allPeople.get(id).getSex() == Sex.MALE) sex = "м";
            else sex = "ж";

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            System.out.println(allPeople.get(id).getName() + " " + sex + " " + dateFormat.format(allPeople.get(id).getBirthDay()));
        }

    }

    public static void delete(int id){

        //int id = Integer.parseInt(args[1]);

        if(allPeople.size() > id && allPeople.get(id) != null){

            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);

        }

    }

    public static void update(String[] args){

        int id = Integer.parseInt(args[0]);

        if(allPeople.size() > id && allPeople.get(id) != null){

            String name = args[1];
            int sexId = 2, dateId = 3;

            if (!args[sexId].equals("ж") && !args[sexId].equals("м")) {
                name = name + " " + args[2];
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

        String name = args[0];
        int sexId = 1, dateId = 2;

        if (!args[sexId].equals("ж") && !args[sexId].equals("м")) {
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

