package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> namesL = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp;

        while (!(temp = reader.readLine()).equals("exit")) {
            namesL.add(temp);
        }

        List<ReadThread> threads = new ArrayList<>();

        for (int i = 0; i < namesL.size(); i++) {
            threads.add(new ReadThread(namesL.get(i)));
            threads.get(i).start();
            threads.get(i).join();
        }

        printM(resultMap);

    }

    public static void printM( Map<String, Integer> map){
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static class ReadThread extends Thread {

        private FileInputStream file;
        private String fileN;

        public ReadThread(String fileName) throws FileNotFoundException{
            //implement constructor body
            if(!fileName.equals(null)) {
                this.fileN = fileName;
                file = new FileInputStream(fileN);
            }

        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run() {
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();

            try {
                while (file.available() > 0) {
                    Character temp;
                    if (!map.containsKey((temp = (char) file.read()))) {
                        map.put(temp, 1);
                    } else {
                        map.put(temp, map.get(temp) + 1);
                        if(map.get(temp) > max) max = map.get(temp);
                    }

                }

                file.close();

                for (Map.Entry<Character, Integer> pair: map.entrySet()) {
                    if(pair.getValue() == max) resultMap.put(fileN, (int)pair.getKey());
                }



            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
