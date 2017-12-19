package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    private boolean flagMinSize;
    private boolean flagMaxSize;
    private boolean flagPartOfName;
    private boolean flagpartOfContent;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

            if((!flagMinSize || Files.size(file) >= minSize) && (!flagMaxSize || Files.size(file) <= maxSize)){
                if (!flagPartOfName || file.getFileName().toString().contains(partOfName)){
                    if (!flagpartOfContent) {
                        foundFiles.add(file);
                    }
                    else {
                        String string = new String(Files.readAllBytes(file));
                        if (string.contains(partOfContent)) {
                            foundFiles.add(file);
                        }
                    }
                }
            }

        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.flagPartOfName = true;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.flagpartOfContent = true;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.flagMinSize = true;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.flagMaxSize = true;
    }
}
