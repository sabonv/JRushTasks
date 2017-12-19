package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Продвинутый поиск файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(500);
        searchFileVisitor.setMaxSize(10000);
//        searchFileVisitor.setMinSize(0);
//        searchFileVisitor.setMaxSize(10);
//        searchFileVisitor.setPartOfName("_no_");
//        searchFileVisitor.setPartOfContent("sdsdccc1");

        Files.walkFileTree(Paths.get("c:\\Users\\v.usov\\IdeaProjects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3101\\test_dir\\"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
