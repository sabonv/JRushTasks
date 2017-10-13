package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(fileName);

        load(inputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

        for (Map.Entry<String, String> pair: this.properties.entrySet()) {
            prop.put(pair.getKey(), pair.getValue());
        }

        prop.store(outputStream, null);
        outputStream.close();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

        prop.load(inputStream);

        for (Map.Entry<Object, Object> pair : prop.entrySet()){
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }

        inputStream.close();
    }

    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();

        sol.fillInPropertiesMap();

        String fileName = "c:\\Users\\v.usov\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2003\\test1.properties";

        OutputStream outputStream = new FileOutputStream(fileName);

        sol.save(outputStream);

    }
}
