package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student stu: this.students) {
            if (stu.getAverageGrade() == averageGrade) return stu;
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:

        double max = 0;

        for (Student stu: this.students) {
            if(stu.getAverageGrade() > max) max = stu.getAverageGrade();
        }

        return getStudentWithAverageGrade(max);
    }

//    public void getStudentWithMinAverageGradeAndExpel( ) {
//        //TODO:
//    }

    public Student getStudentWithMinAverageGrade(){
        double min = students.get(0).getAverageGrade();

        for (Student stu: this.students) {
            if(stu.getAverageGrade() < min) min = stu.getAverageGrade();
        }

        return getStudentWithAverageGrade(min);
        
    }

    public void expel(Student student){
        this.students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}