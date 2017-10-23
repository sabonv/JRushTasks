package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }


    public boolean equals(Object n) {

        if(n == null) return false;
        if(!(n instanceof Solution)) return false;

        if(this == n) return true;

        Solution nn = (Solution)n;

        if (this.hashCode() == 0 && nn.hashCode() == 0) return true;
        if ((first == null && nn.first != null)||(first != null && nn.first == null)) return false;
        if ((last == null && nn.last != null)||(last != null && nn.last == null)) return false;
        if((first == null)&&(nn.first == null)) return nn.last.equals(last);
        if((last == null)&&(nn.last == null)) return nn.first.equals(first);

        return nn.first.equals(first) && nn.last.equals(last);

    }


    public int hashCode() {
        return 31 * (first == null ? 0 : first.hashCode()) + (last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();

        Solution sol1 = new Solution("Donald", "Duck");
        Solution sol2 = new Solution("Donald", "Duck");

        System.out.println(sol1.hashCode());
        System.out.println(sol1);
        System.out.println(sol2.hashCode());
        System.out.println(sol2.getClass());

        System.out.println(sol1.equals(sol2));

        s.add(new Solution(null, "Cuck"));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
