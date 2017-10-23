package com.javarush.task.task21.task2109;

import javax.sound.midi.Soundbank;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A)super.clone();
        }

        @Override
        public int hashCode() {
            return 31 * this.i + this.j;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if(!(obj instanceof A)) return false;
            A a1 = (A)obj;

            if (!(this.getI() == a1.getI()) || !(this.getJ() == a1.getJ())) return false;

            return true;
        }
    }

    public static class B extends A{
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Nel'zya");
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {

            return new C(this.getI(), this.getJ(), this.getName());
        }

        @Override
        public int hashCode() {
            int res = 0;
            res = res + 31 * this.getI() + this.getJ();
            res = res + this.getName() != null?  this.getName().hashCode() : 0;

            return res;

        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if(!(obj instanceof C)) return false;
            C c1 = (C)obj;

            if (!(this.getI() == c1.getI()) || !(this.getJ() == c1.getJ()) || !(this.getName().equals(c1.getName()))) return false;

            return true;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException{


        A a = new A(10, 10);
        A a1 = a.clone();

        //B b = new B(20,20, "NameB");
        //B b1 = b.clone();

        C c = new C(30,30, "NameC");
        C c1 = c.clone();
        C c2 = new C(30,30, "NameC");

        System.out.println(a);
        System.out.println(a1);
        System.out.println(a.equals(a1));


        System.out.println(c);
        System.out.println(c1);
        System.out.println(c.equals(c2));



    }
}
