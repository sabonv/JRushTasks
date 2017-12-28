package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] bPass = getN();
        while (!checkP(bPass)){
            bPass = getN();
        }

        try {
            baos.write(bPass);
        } catch (IOException e) {

        }

        return baos;
    }

    private static boolean checkP(byte[] pass){

        boolean num = false, cha = false, chaB = false;

        for (byte by: pass) {
            if (by >= 49 && by <= 57) num = true;
            if (by >= 97 && by <= 122) cha = true;
            if (by >= 65 && by <= 90) chaB = true;
        }

        return num && cha && chaB;
    }

    private static byte[] getN(){

        byte[] bPass = new byte[8];

        for (int i = 0; i < 8; i++) {

            int sw = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            switch (sw) {

                case 0 : {
                    bPass[i] = (byte) ThreadLocalRandom.current().nextInt(49, 57 + 1);
                    break;
                }
                case 1 : {
                    bPass[i] = (byte) ThreadLocalRandom.current().nextInt(97, 122 + 1);
                    break;
                }
                case 2 : {
                    bPass[i] = (byte) ThreadLocalRandom.current().nextInt(65, 90 + 1);
                    break;
                }
            }

        }



        return bPass;
    }




}