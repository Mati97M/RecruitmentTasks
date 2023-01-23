package dev.mati.tasks;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {
    public static int solution(int[] A) {   //O(N) or O(N * log(N))
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
        }

        boolean bEveryNumInArr = true;
        for (int i = 1; i < A.length + 1; i++) {
            if(!numbers.contains(i)) {
                bEveryNumInArr = false;
            }
        }

        return bEveryNumInArr? 1:0;
    }
}
