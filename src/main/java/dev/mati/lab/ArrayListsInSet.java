package dev.mati.lab;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListsInSet {
    public static void main(String[] args) {
        HashSet<ArrayList<Integer>> s = new HashSet<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

        System.out.println("equals?");
        System.out.println(l1.equals(l2));
        System.out.println(l2.equals(l1));
        System.out.println();
        System.out.println("l1 hashcode: " + l1.hashCode());
        System.out.println("l2 hashcode: " + l2.hashCode());
        System.out.println();

        System.out.println("adding");
        s.add(l1);
        System.out.println(s.add(l2));
        System.out.println(s.size());

    }
}
