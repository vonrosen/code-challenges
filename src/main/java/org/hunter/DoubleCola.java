package org.hunter;

import java.util.LinkedList;
import java.util.Queue;

public class DoubleCola {

    public static void main(String [] args) {
        String [] people = new String [] {
                "Sheldon", "Leonard", "Penny", "Rajesh", "Howard"
        };

        DoubleCola doubleCola = new DoubleCola();
        System.out.println(doubleCola.doubleCola(people, 1));
        System.out.println(doubleCola.doubleCola(people, 2));
        System.out.println(doubleCola.doubleCola(people, 3));
        System.out.println(doubleCola.doubleCola(people, 4));
        System.out.println(doubleCola.doubleCola(people, 5));
        System.out.println(doubleCola.doubleCola(people, 6));
        System.out.println(doubleCola.doubleCola(people, 7));
//        System.out.println(doubleCola.doubleCola(people, 11));
//        System.out.println(doubleCola.doubleCola(people, 12));
//        System.out.println(doubleCola.doubleCola(people, 13));
//        System.out.println(doubleCola.doubleCola(people, 14));
    }

    class Entry {
        String name;
        int size;
        Entry(String name, int size) {
            this.name = name;
            this.size = size;
        }
    }

    /**
     * O(log n)
     * @param people
     * @param n
     * @return
     */
    String doubleCola(String [] people, int n) {
        Queue<Entry> queue = new LinkedList<>();
        for (String name : people) {
            queue.add(new Entry(name, 1));
        }
        int drunk = 0;
        while (true) {
            Entry entry = queue.poll();
            drunk += entry.size;
            if (drunk >= n) {
                return entry.name;
            }
            queue.add(new Entry(entry.name, entry.size * 2));
        }
    }
}
