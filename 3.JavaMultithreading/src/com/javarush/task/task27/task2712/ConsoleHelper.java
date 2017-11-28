package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

/**
 * Created by v.usov on 28.11.2017.
 */
public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException{
        return reader.readLine();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        String temp = "";
        List<Dish> result = new ArrayList<>();
        List<Dish> tempDiL = Arrays.asList(Dish.values());

        writeMessage(Dish.allDishesToString());
        writeMessage("Time to choose: ");

            while (!(temp = readString()).equals("exit")) {
                try {
                    result.add(Dish.valueOf(temp));
                }catch (IllegalArgumentException e) {
                    writeMessage("Bad choose");
                }
            }

        return result;
    }
}
