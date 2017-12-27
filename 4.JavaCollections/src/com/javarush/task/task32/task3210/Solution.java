package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
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
            text = sb.toString().substring(0, sb.toString().length() - 1);

            try(RandomAccessFile wrFile = new RandomAccessFile(file, "rw")){

                if(wrFile.length()>(number+text.length())){
                    wrFile.seek(number);
                    byte[] resultRead = new byte[text.length()];
                    wrFile.read(resultRead, 0, text.length());
                    wrFile.seek(wrFile.length());

                    if (text.equals(convertByteToString(resultRead))) wrFile.write("true".getBytes());
                    else wrFile.write("false".getBytes());

                }

            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }

        }
    }

    public static String convertByteToString(byte[] bytes){

        return new String(bytes);

    }

}
