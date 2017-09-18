package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //FileOutputStream fileName = new FileOutputStream(reader.readLine());

        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        boolean stop = false;
        while(!stop){
            String line = reader.readLine();
            if (!line.equals("exit")){
                writer.write(line + "\n");
            }
            else {
                writer.write(line);
                stop = true;
            }

        }
        reader.close();
        writer.close();

    }
}
