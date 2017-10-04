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

        switch (args[0]) {

            case "-c" : {

                break;
            }
            case "-d" : {
                Map<Integer, String> bufferMapD = new LinkedHashMap<>();

                while ((temp = readerF.readLine()) != null){

                    bufferMapD.put(Integer.parseInt(temp.substring(0,8).replaceAll(" ", "")), temp);

                }
                bufferMapD.remove(Integer.parseInt(args[1]));
                //writF(fileN, bufferMapD);

                break;
            }
            case "-u" : {

                break;
            }

        }







            int maxId = 0;
            List<String> buffer = new ArrayList<>();

            while ((temp = readerF.readLine()) != null){

                buffer.add(temp);
                String tempS = temp.substring(0,8).replaceAll(" ", "");
                if(maxId < Integer.parseInt(tempS)) maxId = Integer.parseInt(tempS);

            }

            readerF.close();

            String name = "", price = "", quantity = "";

            quantity = args[args.length-1];
            price = args[args.length-2];

            if(args.length > 4){

                for (int i = 1; i < args.length-4; i++) {
                    name = name + args[i];
                }

            } else {

                name = args[args.length-3];

            }

            buffer.add(createL(maxId, name, price, quantity));

            writF(fileN, buffer);


    }

    public static void writF(String fileN, List<String> list) throws IOException{

        BufferedWriter fileW = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileN)));

        for (String str: list) {
            fileW.write(str+"\r\n");
        }

        fileW.close();

    }

    public static String createL(int maxId, String name, String price, String quantity){

        String idD, nameD, priceD, quantityD;

        idD = String.valueOf(maxId+1) + "        ";
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
