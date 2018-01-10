package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        System.out.println(s.name + s.i);
        First f = (First) convertOneToAnother(new Second(), First.class);
        System.out.println(f.name + f.i);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, one);

        String json = writer.toString();
        String oneName = one.getClass().getSimpleName().toLowerCase();
        String newName = resultClassObject.getSimpleName().toLowerCase();
        json = json.replaceFirst(oneName, newName);

        StringReader reader = new StringReader(json);

        return mapper.readValue(reader, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public int i = 1;
        public String name = "1";

    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i = 2;
        public String name = "2";

    }
}
