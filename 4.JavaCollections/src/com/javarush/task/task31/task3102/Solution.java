package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        Queue<Path> queue = new PriorityQueue<>();
        List<String> result = new ArrayList<>();
        Path rootPath = Paths.get(root);
        queue.offer(rootPath);
        Path oncePath;

        while (!queue.isEmpty()) {

            oncePath = queue.poll();

            for (File file: (new File(oncePath.toString()).listFiles())) {

                if (file.isDirectory()){
                    queue.offer(file.toPath());
                }
                else {
                    result.add(file.toPath().toString());
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {

    }
}
