package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        try {
            String your_file_name = "c:\\Users\\Administrator\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2014\\test1.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Solution saveSol = new Solution(7);
            System.out.println(saveSol);

            ObjectOutputStream outputStObj = new ObjectOutputStream(outputStream);
            outputStObj.writeObject(saveSol);


            ObjectInputStream inputStrObj = new ObjectInputStream(inputStream);
            Solution loadSol = new Solution(14);
            loadSol = (Solution) inputStrObj.readObject();

            System.out.println(loadSol);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String  string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
