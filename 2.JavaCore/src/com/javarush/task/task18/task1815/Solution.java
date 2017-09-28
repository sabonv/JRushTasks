package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface{

        ATableInterface atb;

        public TableInterfaceWrapper(ATableInterface atb) {
            this.atb = atb;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            atb.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return atb.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            atb.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}