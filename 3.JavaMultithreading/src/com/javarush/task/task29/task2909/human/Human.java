package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{

    private List<Human> children = new ArrayList<>();


    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    //protected int course;

    //protected int[] size;

    public class Size{
        public int height;
        public int weight;
    }

    protected Size size;

    //protected boolean isSoldier;

//    public static final int FIRST = 1;
//    public static final int SECOND = 2;
//    public static final int THIRD = 3;
//    public static final int FOURTH = 4;
    //private int bloodGroup;
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        //this.isSoldier = isSoldier;

        this.name = name;
        this.age = age;

        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getCourse() {
//        return course;
//    }

    public void live() {
//        if (isSoldier)
//            fight();
    }

//    public void fight() {
//    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }



    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

//    public void setChildren(List<Human> children) {
//        this.children = children;
//    }


    public void addChild(Human newHuman){
        this.children.add(newHuman);
    }

    public void removeChild(Human delHuman){
        for (int i = 0; i < children.size(); i++) {
            if(children.get(i).equals(delHuman)) children.remove(i);
        }
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

}