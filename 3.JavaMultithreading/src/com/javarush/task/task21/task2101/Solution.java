package com.javarush.task.task21.task2101;

import java.util.BitSet;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, (byte)1, (byte)2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);



        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        byte[] result = new byte[4];

        for (int i = 0; i < 4; i++) {
            result[i] = (byte) (ip[i] & mask[i]);
        }

        return result;
    }

    public static void print(byte[] bytes) {
        String str = "";
        for (Byte by: bytes) {
            String temp = String.format("%8s", Integer.toBinaryString(by)).replace(' ', '0');
            str += temp.substring(temp.length()-8, temp.length()) + " ";
        }
        System.out.println(str.substring(0, str.length()-1));

    }
}
