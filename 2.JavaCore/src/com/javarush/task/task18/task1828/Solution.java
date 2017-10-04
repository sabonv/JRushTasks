package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileN = reader.readLine();
        reader.close();

        BufferedReader readerF = new BufferedReader(new InputStreamReader(new FileInputStream(fileN)));
        String temp;

        Map<Integer, String> bufferMapD = new LinkedHashMap<>();

        String id ="", name = "", price = "", quantity = "";

        while ((temp = readerF.readLine()) != null){

            bufferMapD.put(Integer.parseInt(temp.substring(0,8).replaceAll(" ", "")), temp);

        }

        readerF.close();

        if(args.length >= 2) {
            switch (args[0]) {

                case "-d": {

                    bufferMapD.remove(Integer.parseInt(args[1]));
                    //writF(fileN, bufferMapD);

                    break;
                }
                case "-u": {

                    id = args[1];
                    quantity = args[args.length - 1];
                    price = args[args.length - 2];

                    if (args.length > 5) {

                        for (int i = 2; i < args.length - 2; i++) {
                            name = name + args[i] + " ";
                        }

                    } else {
                        name = args[args.length - 3];
                    }

                    bufferMapD.put(Integer.parseInt(id), createL(Integer.parseInt(id), name, price, quantity));

                    break;
                }

            }
            writF(fileN, bufferMapD);
        }



    }

    public static void writF(String fileN, Map<Integer, String> map) throws IOException{

        BufferedWriter fileW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileN)));

        for (Map.Entry<Integer, String> pair: map.entrySet()) {
            fileW.write(pair.getValue() + "\r\n");
        }

        fileW.close();

    }

    public static String createL(int id, String name, String price, String quantity){

        String idD, nameD, priceD, quantityD;

        idD = String.valueOf(id) + "        ";
        if(idD.length() > 8) idD = idD.substring(0, 8);

        nameD = name + "                              ";
        if(nameD.length() > 30) nameD = nameD.substring(0, 30);

        priceD = price + "        ";
        if(priceD.length() > 8) priceD = priceD.substring(0, 8);

        quantityD = quantity + "    ";
        if(quantityD.length() > 4) quantityD = quantityD.substring(0, 4);

        return (idD + nameD + priceD + quantityD);

    }
}
