package com.javarush.task.task31.task3112;



import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://cdn.shopify.com/s/files/1/0700/0733/products/deadcat_vmpr_large.jpg", Paths.get("F:/"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        Path temp = Files.createTempFile("download", "url");

        try(InputStream in = url.openStream()) {
            Files.copy(in, temp);
        }
        Path result = Paths.get(downloadDirectory.toString() + url.getFile());

        return Files.move(temp, result);
    }
}
