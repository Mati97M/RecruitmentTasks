package dev.mati.tasks;

public class MaxCounters {
    public static int[] solution(int N, int[] A) {  //performance 60%
        int[] counters = new int[N];
        int maxCounter = 0;
        for(int k = 0; k < A.length; k++) {
            if(A[k] >= 1 && A[k] <= N) { //increase counter
                counters[A[k] - 1] += 1;
                if(counters[A[k] - 1] > maxCounter) {
                    maxCounter = counters[A[k] - 1];
                }
            } else
            if(A[k] == N + 1) { //maxCounter
                for(int c = 0; c < counters.length; c++) {
                    counters[c] = maxCounter;
                }
            }
        }

        return counters;
    }
}
