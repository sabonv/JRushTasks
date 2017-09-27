package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileN1 = reader.readLine(), fileN2 = reader.readLine(), temp;
            BufferedReader readerF1 = new BufferedReader(new InputStreamReader(new FileInputStream(fileN1)));
            BufferedReader readerF2 = new BufferedReader(new InputStreamReader(new FileInputStream(fileN2)));

            while (!((temp = readerF1.readLine()) == null)){
                allLines.add(temp);
            }

            while (!((temp = readerF2.readLine()) == null)){
                forRemoveLines.add(temp);
            }

            reader.close();
            readerF1.close();
            readerF2.close();

            Solution sol = new Solution();
            sol.joinData();

        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void joinData () throws CorruptedDataException {

        boolean del = true;
        int count = 0;

        List<String> tempall = new ArrayList<>(allLines);
        List<String> temprem = new ArrayList<>(forRemoveLines);


        for (int i = 0; i < temprem.size(); i++) {
            for (int j = 0; j < tempall.size(); j++) {
                if(tempall.get(j).equals(temprem.get(i))) {
                    count++;
                    tempall.remove(j);
                }
            }
        }


        if(count == forRemoveLines.size()) {

            System.out.println("DA");

            for (int i = 0; i < forRemoveLines.size(); i++) {
                for (int j = 0; j < allLines.size(); j++) {
                    if(allLines.get(j).equals(forRemoveLines.get(i))) {
                        count++;
                        allLines.remove(j);
                    }
                }
            }

        }
        else {

//            System.out.println("NET");
            allLines.clear();
            throw new CorruptedDataException();
        }

        System.out.println(allLines);

    }
}
