package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 2) {

            File fileNew = new File(args[0]);


            Map<String, ByteArrayOutputStream> tempFiles = new HashMap<>();
            try(ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]))) {

                ZipEntry zipEntry;
                while ((zipEntry = zipIn.getNextEntry()) != null){

                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count = 0;
                    while ((count = zipIn.read(buffer)) != -1)
                        byteArrayOutputStream.write(buffer, 0, count);

                    tempFiles.put(zipEntry.getName(), byteArrayOutputStream);

                }

            }

            try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]))) {
                for (Map.Entry<String, ByteArrayOutputStream> pair : tempFiles.entrySet()) {
                    if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(fileNew.getName())) continue;
                    zipOut.putNextEntry(new ZipEntry(pair.getKey()));
                    zipOut.write(pair.getValue().toByteArray());
                }

                ZipEntry zipEntry = new ZipEntry("new/" + fileNew.getName());
                zipOut.putNextEntry(zipEntry);
                Files.copy(fileNew.toPath(), zipOut);
            }


        }

    }
}
