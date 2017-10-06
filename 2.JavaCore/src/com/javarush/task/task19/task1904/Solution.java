package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String line = fileScanner.nextLine();

            String[] arrS = line.split(" ");



            String dateS=arrS[3] + "." + arrS[4] + "." + arrS[5];
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            Date dateB = null;
            try {
                dateB = format.parse(dateS);
            }catch (ParseException e) {
                System.out.println(e.getMessage());
            }
            //Иванов Иван Иванович 31 12 1950
            //String firstName, String middleName, String lastName, Date birthDate

            return new Person(arrS[1], arrS[2], arrS[0], dateB);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
