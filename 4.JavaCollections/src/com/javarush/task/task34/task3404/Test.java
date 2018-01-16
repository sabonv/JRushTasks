package com.javarush.task.task34.task3404;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v.usov on 16.01.2018.
 */
public class Test {

    public static void main(String[] args) {


        String result = "sin2*0/10-5^6";
//
//        if (result.indexOf("/") < result.indexOf("*")) System.out.println("/ " + result.indexOf("/"));
//        else System.out.println("* " + result.indexOf("*"));
//        System.out.println();
//        System.out.println("/ " + result.indexOf("/"));
//        System.out.println("* " + result.indexOf("*"));
        //System.out.println(Math.cos(Math.toRadians(180)));

        int count = 0;

        Matcher m = Pattern.compile("([\\-\\+\\*\\/\\^])").matcher(result);
        while (m.find())count++;

        System.out.println("VOT: " + count);

//        Matcher minusM = Pattern.compile("^([\\-])([\\d\\.]*)$").matcher("2-4.0");
//
//        if(minusM.find()) {
//            System.out.println("da");
//
//            for (int i = 0; i < minusM.groupCount(); i++) {
//                System.out.println(minusM.group(i));
//            }
//
//        }
//
//        else System.out.println("net");

    }


}
