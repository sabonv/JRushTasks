package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException{

        if (args.length > 2){

            int partOfFileCount = args.length -1;
            Set<String> parts = new TreeSet<>();
            for (int i = 0; i < partOfFileCount; i++) {
                parts.add(args[i+1]);
            }

            List<FileInputStream> inStreams = new ArrayList<>();
            for (String str: parts) {
                inStreams.add(new FileInputStream(str));
            }

            try(SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(inStreams));
                ZipInputStream zipInStream = new ZipInputStream(seqInStream);
                FileOutputStream resultF = new FileOutputStream(args[0])){

                byte[] buf = new byte[1024 * 1024];
                while (zipInStream.getNextEntry() != null){
                    int count;

                    while((count = zipInStream.read(buf)) != -1){
                        resultF.write(buf, 0, count);
                    }

                }

            }

        }

    }
}
