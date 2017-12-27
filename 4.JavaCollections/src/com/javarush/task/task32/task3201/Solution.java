package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {

        if(args.length >= 3) {

            int number = Integer.valueOf(args[1]);
            String file = args[0];
            String text;
            StringBuilder sb = new StringBuilder();

            for (int i = 2; i < args.length; i++) {

                sb.append(args[i]);
                sb.append(" ");

            }
            text = sb.toString().substring(0, sb.toString().length()-1);
            //System.out.println(text);

            try(RandomAccessFile wrFile = new RandomAccessFile(file, "rw")){

                if(wrFile.length()<number){

                    wrFile.seek(wrFile.length());
                    wrFile.write(text.getBytes());
                } else {
                    wrFile.seek(number);
                    wrFile.write(text.getBytes());
                }

            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }

        }

    }
}
