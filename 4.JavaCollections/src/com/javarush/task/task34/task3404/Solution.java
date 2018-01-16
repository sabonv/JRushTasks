package com.javarush.task.task34.task3404;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        //solution.finder("sin(2*(-5+1.5*4)+28)");
        //solution.finder("2+8*(9/(4-1.5))^(1+1)");
        //solution.finder1("sin(2*(-5+1.5*4)+28)");
        //solution.finder1("1+4/2/2+2^2+2*2-2^(2-1+1)");

        //solution.finder1("2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)");
        //solution.calc("(3+2-3)", 0);
        //solution.calc("(2+2)");
        //solution.calc("(2*3/3*2)");
        //solution.calc("(25*123.12-45877*25)");
    }

    public void recursion(final String expression, int countOperation) {

        int oper = countOperation;

        Matcher operM = Pattern.compile("([\\-\\+\\*\\/\\^])").matcher(expression);
        while (operM.find())oper++;

        String temp = expression;
        final Matcher m = Pattern.compile("(\\()([\\d \\-\\+\\*\\/\\^\\.]*)(\\))").matcher(temp);
        int func=0;
        while(m.find()){


            String res = m.group(0);
            //System.out.println(res);
            //System.out.println();



            //System.out.println(temp.substring(m.start(0)-3,m.start()));

            int start;
            String funcS = "";
            if (m.start(0)>=3) {
                switch (temp.substring(m.start(0) - 3, m.start())) {

                    case "sin":
                        func = 1;
                        oper++;
                        funcS ="sin";
                        break;
                    case "cos":
                        func = 2;
                        oper++;
                        funcS = "cos";
                        break;
                    case "tan":
                        func = 3;
                        oper++;
                        funcS = "tan";
                        break;

                }
            }

            temp = temp.replace(funcS+m.group(0), calc(m.group(0), func)).replace("--", "+");

        }
        if (temp.contains("(") || temp.contains(")")) recursion(temp, oper);
        //System.out.println("Output:");
        if(!temp.contains("(") || !temp.contains(")")) calc(temp, 0);
        //System.out.println("OPER:" + oper);

        if(!temp.contains("(") || !temp.contains(")")) System.out.print("expected output "+temp+" " + (oper));

        //implement
    }


    public int finder1(String str) {

        int oper = 0;

        Matcher operM = Pattern.compile("([\\-\\+\\*\\/\\^])").matcher(str);
        while (operM.find())oper++;

        String temp = str;
        final Matcher m = Pattern.compile("(\\()([\\d \\-\\+\\*\\/\\^\\.]*)(\\))").matcher(temp);
        int func=0;
        while(m.find()){


            String res = m.group(0);
            //System.out.println(res);
            //System.out.println();



            //System.out.println(temp.substring(m.start(0)-3,m.start()));

            int start;
            String funcS = "";
            if (m.start(0)>=3) {
                switch (temp.substring(m.start(0) - 3, m.start())) {

                    case "sin":
                        func = 1;
                        oper++;
                        funcS ="sin";
                        break;
                    case "cos":
                        func = 2;
                        oper++;
                        funcS = "cos";
                        break;
                    case "tan":
                        func = 3;
                        oper++;
                        funcS = "tan";
                        break;

                }
            }

            temp = temp.replace(funcS+m.group(0), calc(m.group(0), func)).replace("--", "+");

        }
        if (temp.contains("(") || temp.contains(")")) finder1(temp);
        //System.out.println("Output:");
        if(!temp.contains("(") || !temp.contains(")")) calc(temp, 0);
        //System.out.println("OPER:" + oper);

        if(!temp.contains("(") || !temp.contains(")")) System.out.print("expected output "+temp+" " + (oper+1));

        return oper+1;
    }

    public String calc(String str, int func){

        str = str.replace("(", "").replace(")", "");
        String result = str;
        List<String> masks = new ArrayList<>();
        Matcher m4;
        masks.add("([\\d\\.\\-]*)(\\^)([\\d\\.]*)");
        masks.add("([\\d\\.]*)(\\*)([\\d\\.]*)");
        masks.add("([\\d\\.]*)(\\/)([\\d\\.]*)");
        masks.add("([\\-]?[\\d\\.]+)(\\-)([\\d\\.]*)");
        masks.add("([\\-]?[\\d\\.]*)(\\+)([\\d\\.]*)");

        //result = "30";
        //func = 1;
            for (int i = 0; i < masks.size(); i++) {

                if ((result.contains("*") || result.contains("/"))&& i>0){

                    int delit = result.indexOf("/");
                    int umozh = result.indexOf("*");
                    if (delit<0) delit = Integer.MAX_VALUE;
                    if (umozh<0) umozh = Integer.MAX_VALUE;

                    if (delit < umozh) i = 2;
                    else i=1;

                }

                m4 = Pattern.compile(masks.get(i)).matcher(result);
                while(m4.find()){

                    //System.out.println(m4.group(0));

                    double calcRes = 0;

                    switch (i){
                        case 0:{
                            calcRes =  Math.pow(Double.valueOf(m4.group(1)),Double.valueOf(m4.group(3)));
                            break;
                        }
                        case 1:{
                            calcRes =  Double.valueOf(m4.group(1)) * Double.valueOf(m4.group(3));
                            break;
                        }
                        case 2:{
                            calcRes =  Double.valueOf(m4.group(1)) / Double.valueOf(m4.group(3));
                            break;
                        }
                        case 4:{

                            calcRes =  Double.valueOf(m4.group(1)) + Double.valueOf(m4.group(3));
                            break;
                        }
                        case 3:{
                            Matcher  minusM = Pattern.compile("^([\\-])([\\d\\.]*)$").matcher(result);

                            if(minusM.find()){
                                //System.out.println("END " + result);
                                return result;
                            }
                            else calcRes =  Double.valueOf(m4.group(1)) - Double.valueOf(m4.group(3));
                            break;
                        }
                    }

                    //System.out.println(String.valueOf(calcRes));

                    if (i==3 && calcRes<0){
                        result = result.replace(m4.group(0), String.valueOf(calcRes)).replace("+-", "-");
                    }

                    result = result.replace(m4.group(0), String.valueOf(calcRes)).replace(".0.0", ".0");

                    m4 = Pattern.compile(masks.get(i)).matcher(result);
                    //System.out.println(result);
                    //System.out.println();
                    if (i==1 || i == 2) break;
                }

            }



            switch (func){

                case 0: {
                    //
                    break;
                }
                case 1: {
                    //sin
                    result = String.valueOf(Math.sin(Math.toRadians(Double.valueOf(result))));
                    break;
                }
                case 2: {
                    //cos
                    result = String.valueOf(Math.cos(Math.toRadians(Double.valueOf(result))));
                    break;
                }
                case 3: {
                    result = String.valueOf(Math.tan(Math.toRadians(Double.valueOf(result))));
                    break;
                }

            }

        double tempD = new BigDecimal(Double.valueOf(result)).setScale(2, RoundingMode.UP).doubleValue();
        result = String.valueOf(tempD);
        //System.out.println("END " + result);
        return result;
    }


    public Solution() {
        //don't delete
    }
}
