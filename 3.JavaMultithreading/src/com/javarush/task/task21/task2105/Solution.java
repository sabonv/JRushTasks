package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;

        if (!(o instanceof Solution))
            return false;

        Solution n = (Solution) o;


        if (this.hashCode() == 0 && n.hashCode() == 0) return true;
        if ((first == null && n.first != null)||(first != null && n.first == null)) return false;
        if ((last == null && n.last != null)||(last != null && n.last == null)) return false;
        if((first == null)&&(n.first == null)) return n.last.equals(last);
        if((last == null)&&(n.last == null)) return n.first.equals(first);

        return n.first.equals(first) && n.last.equals(last);

    }

    public int hashCode() {
        return 31 * (first == null ? 0 : first.hashCode()) + (last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {


        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
