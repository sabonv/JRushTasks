package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

        Map<String, String> testMap = new LinkedHashMap<>();
        testMap.put("name", "sas");
        testMap.put("age", "12");
        testMap.put("test", null);

        System.out.println(getQuery(testMap));

    }
    public static String getQuery(Map<String, String> params) {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String,String> pair: params.entrySet()) {
            if(pair.getValue() != null && !pair.getValue().equals("")){
                if (result.length() != 0) result.append(" and ");
                result.append(pair.getKey() + " = '" + pair.getValue() + "'");
            }
        }

        return result.toString();
    }
}
