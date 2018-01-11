package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by v.usov on 11.01.2018.
 */

@XmlType(name = "shop")
@XmlRootElement

public class Shop {

    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    Shop(){}

    static class Goods{
        public List<String> names;
    }


}
