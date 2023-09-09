package dev.mati.tasks.HackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChocolateBox {
    public static void main(String[] args) {
        System.out.println(box(6,6,new ArrayList<>(List.of(4)),new ArrayList<>(List.of(2))));
        System.out.println(box(3,3,new ArrayList<>(List.of(2)),new ArrayList<>(List.of(2))));
        System.out.println(box(3,2,new ArrayList<>(List.of(1,2,3)),new ArrayList<>(List.of(1,2))));

    }
    public static long box(int n, int m, List<Integer> h,List<Integer> v) {

        long maxArea = 0;
        int maxHGap = (h.size() > 0) ? 2:1;
        int maxVGap = (v.size() > 0) ? 2:1;
        Collections.sort(h);
        Collections.sort(v);

        int start = h.get(0);
        int counter = 1;
        for(int i = 1; i < h.size(); i++) {
            if(start + 1 == h.get(i)) {
                counter++;
                start++;
            } else {
                counter = 1;
                start = h.get(i);
            }
            maxHGap = Math.max(maxHGap,counter + 1);
        }

        if(v.size() > 0) {
            start = v.get(0);
        }
        counter = 1;
        for(int i = 1; i < v.size(); i++) {
            if(start + 1 == v.get(i)) {
                counter++;
                start++;
            } else {
                counter = 1;
                start = v.get(i);
            }
            maxVGap = Math.max(maxVGap, counter + 1);
        }

        maxArea =  maxVGap * maxHGap;
        return maxArea;
    }
}
