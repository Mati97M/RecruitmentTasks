package dev.mati.tasks;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public static int PerfectSolution(int[] A) {    //100%    O(N) or O(N * log(N))
        Set<Integer> positiveNumbers = new HashSet<>();
        int maxVal = 1_000_000;

        for(int i = 0; i < A.length; i++) {
            if(A[i] > 0) {
                positiveNumbers.add(A[i]);
                maxVal = Math.max(maxVal,A[i]);
            }
        }
        if(positiveNumbers.isEmpty()) {
            return 1;
        }

        int smallestPositiveAbsent = 1;
        for (int i = 1; i < maxVal; i++) {
            if(!positiveNumbers.contains(i)) {
                smallestPositiveAbsent = i;
                return smallestPositiveAbsent;
            }
        }

        smallestPositiveAbsent = maxVal + 1;
        return smallestPositiveAbsent;
    }

    public static int bestSolution(int[] A) { //100%    O(N) or O(N * log(N))

        int smallestPositiveAbsent = 0;
        int maxVal = - 1_000_000;
        int minVal = 1_000_000;

        HashSet<Integer> values = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            values.add(A[i]);
            if(A[i] > maxVal) {
                maxVal = A[i];
            }
            if(A[i] < minVal) {
                minVal = A[i];
            }
        }

        boolean bContainsAll = true;
        if(maxVal <= 0 || minVal > 1) {
            smallestPositiveAbsent = 1;
        } else {
            for(int i = 1; i <= maxVal; i++) {
                if(!values.contains(i)) {
                    smallestPositiveAbsent = i;
                    bContainsAll = false;
                    break;
                }
            }
            if(bContainsAll) {
                smallestPositiveAbsent = maxVal + 1;
            }
        }
        return smallestPositiveAbsent;
    }

    public static int solution(int[] A) {//88%|  correctness 100%| performance 75%
                                            //time complexity: O(N) or O(N * log(N))
        int smallestPositiveAbsent = 0;
        int maxVal = - 1_000_000;
        int minVal = 1_000_000;

        HashSet<Integer> values = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            values.add(A[i]);
            if(A[i] > maxVal) {
                maxVal = A[i];
            }
            if(A[i] < minVal) {
                minVal = A[i];
            }
        }

        boolean bContainsAll = true;
        if(maxVal <= 0 || minVal > 1) {
            smallestPositiveAbsent = 1;
        } else {
            for(int i = minVal; i <= maxVal; i++) {
                if(!values.contains(i)) {
                    if(i > 0) {
                        smallestPositiveAbsent = i;
                        bContainsAll = false;
                        break;
                    }

                }
            }
            if(bContainsAll) {
                smallestPositiveAbsent = maxVal + 1;
            }
        }
        return smallestPositiveAbsent;
    }
}
