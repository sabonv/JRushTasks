package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> namesM = new TreeMap<>();
        String name, nameRes = "";

        while (!(name = reader.readLine()).equals("end")) {

            String[] namePars = name.split("\\.");
            nameRes = name.replaceAll("\\." + namePars[namePars.length-1], "");

            String[] nameSpDot = name.split("\\.");
            int num = Integer.parseInt(nameSpDot[nameSpDot.length-1].substring(4));
            //System.out.println(num);

            namesM.put(num, name);
        }

        reader.close();

        //System.out.println(namesM);


        //System.out.println(nameRes);

        FileOutputStream fileWres = new FileOutputStream(nameRes);
        FileInputStream fileR;
        byte[] tempB;

        for (Map.Entry<Integer, String> pair: namesM.entrySet()) {

            fileR = new FileInputStream(pair.getValue());
            tempB = new byte[fileR.available()];
            fileR.read(tempB);
            fileR.close();
            fileWres.write(tempB);
            fileWres.flush();
        }

        fileWres.close();

    }
}
