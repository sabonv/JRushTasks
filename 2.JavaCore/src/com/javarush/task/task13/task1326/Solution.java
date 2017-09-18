package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileInputStream(reader.readLine()));
        List<Integer> arr = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Integer temp = Integer.parseInt(data);
            if ((temp % 2) == 0 ){
                arr.add(temp);
            }
        }
        for (int i = arr.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int t = arr.get(j);
                    arr.set(j, arr.get(j + 1)) ;
                    arr.set((j + 1), t);
                }
            }
        }

        for (Integer d: arr) {
            System.out.println(d);
        }

        scanner.close();
        reader.close();
    }
}
