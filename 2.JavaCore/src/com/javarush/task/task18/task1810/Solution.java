package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean stop = false;

        FileInputStream temp;

        while(!stop){
            if ((temp = new FileInputStream(reader.readLine())).available() < 1000) {
                stop = true;
                reader.close();
                temp.close();
                throw new DownloadException();
            }
            else {
                temp.close();
            }

        }

        reader.close();

    }

    public static class DownloadException extends Exception {

    }
}
