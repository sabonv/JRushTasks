package com.javarush.task.task31.task3110;

import com.sun.nio.zipfs.ZipPath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by v.usov on 14.11.2017.
 */
public class Archiver {

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Davay patch for zip:");
            Path pathZip = Paths.get(reader.readLine());
            ZipFileManager zipFileManager = new ZipFileManager(pathZip);

            System.out.println("Davay patch of target:");
            Path pathTarget = Paths.get(reader.readLine());
            zipFileManager.createZip(pathTarget);


        }catch (Exception e) {

        }


    }

}
