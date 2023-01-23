package dev.mati.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PermMissingElem {

    public static int bestSolution(int[] A) {	//O(N) or O(N * log(N))

        int missingEl = -1;
        Set<Integer> elementsSet = new HashSet<>();

        for(int i = 0; i < A.length; i++) {
            elementsSet.add(A[i]);
        }

        for (int i = 1; i <= A.length + 1; i++) {
            if(!elementsSet.contains(i)) {
                missingEl = i;
                break;
            }
        }
        return missingEl;
    }

    public static int notTheBestSolution(int[] A) { //N**2

        int missingEl = -1;
        Set<Integer> elementsSet = new TreeSet<>();  //chyba dlatego, że sortuje podczas wstawiania

        for(int i = 0; i < A.length; i++) {
            elementsSet.add(A[i]);
        }

        for (int i = 1; i <= A.length + 1; i++) {
            if(!elementsSet.contains(i)) {
                missingEl = i;
                break;
            }
        }
        return missingEl;
    }

    public static int badSolution(int[] A) {// runtime error i coś jeszzce
        Arrays.sort(A);
        int missingEl = A[0];
        int prevEl = missingEl;

        for (int i = 1; i < A.length; i++) {
            if(prevEl + 1 != A[i]) {
                missingEl = prevEl + 1;
                return missingEl;
            }
            prevEl = A[i];
        }

        return missingEl;
    }
}
