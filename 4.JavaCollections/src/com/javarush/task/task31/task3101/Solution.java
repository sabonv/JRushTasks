package com.javarush.task.task31.task3101;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

import static com.javarush.task.task31.task3101.FileUtils.deleteFile;
import static com.javarush.task.task31.task3101.FileUtils.isExist;
import static com.javarush.task.task31.task3101.FileUtils.renameFile;

/*
Проход по дереву файлов
*/
public class Solution {

    public static Map<String, File> smallFiles = new TreeMap<>();

    public static void main(String[] args) {

        if(args.length == 2) {
            //create path
            Path rootPath = Paths.get(args[0]);

            //create result file
            File fileResult = new File(args[1]);
            File fileResultRenamed = new File(fileResult.getParent() + "/allFilesContent.txt");

            //rename result file
            if (isExist(fileResult)) renameFile(fileResult, fileResultRenamed);

            //write all files from TreeMap in to result file
            //close all stream
            try (FileOutputStream writeFile = new FileOutputStream(fileResultRenamed)){
                //check all files(size > 50kb ) ? del : TeeMap
                getSmallFiles(rootPath, smallFiles);

                for (Map.Entry<String, File>  file: smallFiles.entrySet()) {

                    //System.out.println(file.getKey());
                    Files.copy(file.getValue().toPath(), writeFile);
                    writeFile.write("\n".getBytes());

                }
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }

        }

    }

    private static void getSmallFiles(Path rootPath, Map<String, File> smallFiles) {
        //check all files(size > 50kb ) ? del : TeeMap
        //use recursion

        for (File file: (new File(rootPath.toString()).listFiles())) {

            if (file.isDirectory()){
                getSmallFiles(file.toPath(), smallFiles);
            }

            else {
                if (file.length() > 50) {
                    deleteFile(file);
                    //System.out.println(file.getName() + " - deleted!");
                }
                else smallFiles.put(file.getName(), file);
            }

        }

    }

}
