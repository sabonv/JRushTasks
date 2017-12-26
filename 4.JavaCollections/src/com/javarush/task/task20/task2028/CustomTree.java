package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {

    Entry<String> root;

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }


        System.out.println(list.size());
        System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));

    }

    @Override
    public int size() {
        int size = 0;
        if (root == null) {
            return size;
        }

        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<String> currentE = queue.poll();
            if (currentE.leftChild != null){
                queue.offer(currentE.leftChild);
                size++;
            }
            if (currentE.rightChild != null){
                queue.offer(currentE.rightChild);
                size++;
            }

        }

        return size;
    }

    @Override
    public boolean add(String s) {

        if(root == null) {
            root = new Entry<>("0");
            //return true;
        }

        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){

            Entry<String> currentE = queue.poll();
            if (currentE.isAvailableToAddChildren()){
                if (currentE.availableToAddLeftChildren) {
                    currentE.leftChild = new Entry<>(s);
                    currentE.leftChild.parent = currentE;
                    currentE.leftChild.lineNumber = 1 + currentE.lineNumber;
                    currentE.checkChildren();
                    return true;
                }
                else if (currentE.availableToAddRightChildren){
                    currentE.rightChild = new Entry<>(s);
                    currentE.rightChild.parent = currentE;
                    currentE.rightChild.lineNumber = 1 + currentE.lineNumber;
                    currentE.checkChildren();
                    return true;
                }
            }
            else {
                if(currentE.leftChild != null) queue.offer(currentE.leftChild);
                if(currentE.rightChild != null) queue.offer(currentE.rightChild);
            }

        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        String s = "";
        if (o instanceof String) s = (String) o;

        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<String> currentE = queue.poll();
            if (currentE.leftChild != null){
                if (currentE.leftChild.elementName.equals(s)) {
                    currentE.leftChild = null;
                    return true;
                }
                else queue.offer(currentE.leftChild);
            }
            if (currentE.rightChild != null){
                if (currentE.rightChild.elementName.equals(s)) {
                    currentE.rightChild = null;
                    return true;
                }
                else queue.offer(currentE.rightChild);
            }

        }

        return false;

    }

    public String getParent(String s){

        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry<String> currentE = queue.poll();
            if (currentE.leftChild != null){
                if (currentE.leftChild.elementName.equals(s)) return currentE.leftChild.parent.elementName;
                else queue.offer(currentE.leftChild);
            }
            if (currentE.rightChild != null){
                if (currentE.rightChild.elementName.equals(s)) return currentE.rightChild.parent.elementName;
                else queue.offer(currentE.rightChild);
            }

        }

        return null;
    }

    @Override
    public String get(int index) {

        throw new UnsupportedOperationException();

        //return null;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
        //return super.set(index, element);
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
        //super.add(index, element);
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
        //return super.remove(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }

    static class Entry<T> implements Serializable{
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;

        }

        void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren(){
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }


}
