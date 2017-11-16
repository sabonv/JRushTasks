package com.javarush.task.task27.task2711;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.zip.ZipEntry;

/**
 * Created by v.usov on 15.11.2017.
 */
public class Test {

    public static void main(String[] args) {

        String sourseS = "c:\\Users\\v.usov\\IdeaProjects\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task27\\task2711\\";
        String sourseSf = "c:\\Users\\v.usov\\IdeaProjects\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task27\\task2711\\ACS_RONA.JPG";
        Path pathZip = Paths.get(sourseS);
        Path pathZipF = Paths.get(sourseSf);


//        String name2 = pathZipF.toFile().getName();
//        System.out.println(name2);
//        System.out.println("-------------------");
        File files = pathZipF.toFile();

        if (files.isDirectory()) {
            for (File f : files.listFiles()) {
                System.out.println(f.getName());
            }
        } else if(files.isFile()) {
            System.out.println(files.getName());
        }

        //ZipEntry zipEntry = new ZipEntry(name2);
        String name = "namr";
        long size = 2048;
        long compressedSize = 1024;

        System.out.println(String.format("%s\t%d Kb (%d Kb) сжатие: %d%%",name, (size/1024), (compressedSize/1024), (100 - ((compressedSize * 100) / size)) ));


    }

}
