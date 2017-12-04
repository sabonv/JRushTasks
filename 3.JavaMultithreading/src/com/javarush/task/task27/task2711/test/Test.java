package com.javarush.task.task27.task2711.test;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

    private static PrimeStorage storage = PrimeStorage.getInstance();
    private static int weightAll = 100;

    public static void main(String[] args) {

        List<Prime> choose = timeToChoose(weightAll, storage.list(), storage.list().size());

        if(choose == null || choose.size() == 0){
            System.out.println("Zhopa");
            System.exit(0);
        }
        System.out.println("Vot takoy nabor dlya razmera = " + weightAll + ":");
        for (Prime pr: choose) {
            System.out.println(String.format("%s - Dlinna %d, cena %d", pr.getName(), pr.getWeight(), pr.getCost()));
        }

    }

    public static List<Prime> timeToChoose(int weightAll, List<Prime> inList, int size){
        if(weightAll == 0 || size == 0) return null;

        if(inList.get(size - 1).getWeight() > weightAll) return timeToChoose(weightAll, inList, (size - 1));

        else {

            List<Prime> l1 = new ArrayList<>();
            l1.add(inList.get(size - 1));
            List<Prime> t = timeToChoose(weightAll - inList.get(size - 1).getWeight(), inList, size -1);

            if(t != null) l1.addAll(t);

            List<Prime> l2 = timeToChoose(weightAll, inList, size - 1);

            if (getAllCost(l1) == getAllCost(l2)){
                if (getAllWeight(l1) == getAllWeight(l2))
                    return l1.size() < (l2 != null ? l2.size() : Integer.MAX_VALUE) ? l1 : l2;
                else
                    return getAllWeight(l1) > getAllWeight(l2) ? l1 : l2;
            } else {
                return getAllCost(l1) > getAllCost(l2) ? l1 : l2;
            }

        }

    }

    public static int getAllCost(List<Prime> temp){
        int sum =0;
        if (temp == null) return sum;
        for (Prime pr: temp) {
            sum+=pr.getCost();
        }
        return sum;
    }

    public static int getAllWeight(List<Prime> temp) {
        int sum =0;
        if (temp == null) return sum;
        for (Prime pr: temp) {
            sum += pr.getWeight();
        }
        return sum;
    }



}
