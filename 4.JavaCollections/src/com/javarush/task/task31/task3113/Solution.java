package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static int allFiles = 0;
    static long allSize = 0;
    static int allFolders = 0;

    public static void main(String[] args) throws IOException {

        try
        (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Path path = Paths.get(reader.readLine());
            if(Files.isDirectory(path)){

                Files.walkFileTree(path, new SimpleFileVisitor<Path>(){

                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                        Solution.allFolders++;

                        return super.preVisitDirectory(dir, attrs);
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                        if (!Files.isDirectory(file)){
                            Solution.allFiles++;
                            Solution.allSize += Files.size(file);
                        }

                        return super.visitFile(file, attrs);
                    }
                });

                System.out.println("Всего папок - " + (allFolders-1));
                System.out.println("Всего файлов - " + allFiles);
                System.out.println("Общий размер - " + allSize);


            } else {
                System.out.println(path.toString() + " - не папка");
            }

        }

    }
}
