package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //+add your code here - добавьте код тут

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {

        public BufferedReader readerF;
        public String result = "";

        @Override
        public void setFileName(String fullFileName) {
            try {
                readerF = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
            }
            catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public String getFileContent() {
            return result;
        }

        public void run(){

            String temp;
            try {
                while (!((temp = readerF.readLine()) == null)){
                    result = result + temp + " ";
                }
                result = result.substring(0, result.length()-1);
                readerF.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
