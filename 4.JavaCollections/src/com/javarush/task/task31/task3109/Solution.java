package com.javarush.task.task31.task3109;

import java.io.*;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("c:\\Users\\v.usov\\IdeaProjects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3109\\properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("c:/Users/v.usov/IdeaProjects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        //properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        //properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        Properties result = new Properties();
        int index = fileName.lastIndexOf('.');
        String ext = index == -1? "" : fileName.substring(index);

        try{

            switch (ext) {
                case ".xml" :{
                    InputStream fileReader = new FileInputStream(fileName);
                    result.loadFromXML(fileReader);
                    fileReader.close();
                    return result;
                }

                default: {
                    FileReader fileReader = new FileReader(fileName);
                    result.load(fileReader);
                    fileReader.close();
                    return result;
                }
            }

        }catch (FileNotFoundException e) {
            return result ;
        } catch (IOException e) {
            return result ;
        }

        //return result;
    }
}
