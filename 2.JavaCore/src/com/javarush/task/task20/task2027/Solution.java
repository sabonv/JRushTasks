package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

        List<Word> test = detectAllWords(crossword, "home", "same");
        System.out.println(test);
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> result = new ArrayList<>();
        int overI = crossword.length-1, overJ = crossword[0].length-1;


        for (String word: words) { //поиск для каждого слова


            char[] wordCh = word.toCharArray(); //массив чаров из слова

            int[] startP = new int[] {0, 0}; // старотовая точка слова

            for (int i = 0; i < crossword.length; i++) {        //обход всего массива
                for (int j = 0; j < crossword[0].length; j++) { // --//--

                    if(crossword[i][j] == wordCh[0]) { //найден первый символ
                        startP = new int[] {i, j}; // сохраняем координаты первого символа в переменную

                        int[][] wordChVars = new int[8][wordCh.length + 2]; // массив слов вокруг первого символа и координаты последнего символа


                        if ((i - (wordCh.length-1) >= 0)&&(j - (wordCh.length-1) >= 0)) {
                            wordChVars[0][0] = wordCh[0]; //диагональ лево вверх
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[0][k] = crossword[i-k][j-k];
                            }
                            wordChVars[0][wordCh.length ] = i - (wordCh.length-1);
                            wordChVars[0][wordCh.length + 1] = j - (wordCh.length-1);
                        }

                        if ((i - (wordCh.length-1) >= 0)) {
                            wordChVars[1][0] = wordCh[0]; //строка вверх
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[1][k] = crossword[i-k][j];
                            }
                            wordChVars[1][wordCh.length ] = i - (wordCh.length-1);
                            wordChVars[1][wordCh.length + 1] = j;
                        }

                        if ((i- (wordCh.length-1) >=0)&&(j+ (wordCh.length-1) < overJ)) {
                            wordChVars[2][0] = wordCh[0]; //диагональ право вверх
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[2][k] = crossword[i-k][j+k];
                            }
                            wordChVars[2][wordCh.length ] = i - (wordCh.length-1);
                            wordChVars[2][wordCh.length + 1] = j + (wordCh.length-1);
                        }

                        if ((j+(wordCh.length-1)<overJ)) {
                            wordChVars[3][0] = wordCh[0]; //строка право
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[3][k] = crossword[i][j+k];
                            }
                            wordChVars[3][wordCh.length ] = i;
                            wordChVars[3][wordCh.length + 1] = j+ (wordCh.length-1);
                        }

                        if ((i+(wordCh.length-1)-1<overI)&&(j+(wordCh.length-1)<overJ)) {
                            wordChVars[4][0] = wordCh[0]; //диагональ право низ
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[4][k] = crossword[i+k][j+k];
                            }
                            wordChVars[4][wordCh.length ] = i+ (wordCh.length-1);
                            wordChVars[4][wordCh.length + 1] = j + (wordCh.length-1);
                        }

                        if ((i+(wordCh.length-1)<overI)) {
                            wordChVars[5][0] = wordCh[0]; //строка вниз
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[5][k] = crossword[i+k][j];
                            }
                            wordChVars[5][wordCh.length ] = i+(wordCh.length-1);
                            wordChVars[5][wordCh.length + 1] = j;
                        }

                        if ((i+(wordCh.length-1)<overI)&&(j-(wordCh.length-1)>=0)) {
                            wordChVars[6][0] = wordCh[0]; //диагональ лево низ
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[6][k] = crossword[i+k][j-k];
                            }
                            wordChVars[6][wordCh.length ] = i+(wordCh.length-1);
                            wordChVars[6][wordCh.length + 1] = j-(wordCh.length-1);
                        }

                        if ((j-(wordCh.length-1)>=0)) {
                            wordChVars[7][0] = wordCh[0]; //строка лево
                            for (int k = 1; k < wordCh.length; k++) {
                                wordChVars[7][k] = crossword[i][j-k];
                            }
                            wordChVars[7][wordCh.length ] = i;
                            wordChVars[7][wordCh.length + 1] = j-(wordCh.length-1);
                        }


                        for (int[] wordTest: wordChVars) { //сравнение слов вокруг первого символа со словом *
                            boolean checkKey = true; // ключ совпадения

                            if (wordTest[0] != 0) { // проверка на пустое слово
                                for (int k = 0; k < wordCh.length; k++) {
                                    if (wordTest[k] != wordCh[k]) {
                                        checkKey = false;
                                        break;
                                    }
                                }
                                if(checkKey) {
                                    Word tempW = new Word(word);
                                    tempW.setStartPoint(startP[1], startP[0]);
                                    tempW.setEndPoint(wordTest[wordCh.length+1], wordTest[wordCh.length]);
                                    result.add(tempW);
                                }
                            }

                        }

                    }

                }
            }

        }


        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
