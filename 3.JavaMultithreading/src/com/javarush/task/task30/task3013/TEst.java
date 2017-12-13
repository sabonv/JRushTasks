package com.javarush.task.task30.task3013;

/**
 * Created by v.usov on 13.12.2017.
 */
public class TEst {

    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
//            System.out.println((int)(Math.random()*2));
//        }


        int[][] test = new int[3][3];

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length; j++) {
                test[i][j] = i+j;
            }
        }

        for (int i: test[2]) {
            System.out.print(i + " ");
        }



    }

}
