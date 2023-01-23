package dev.mati.tasks;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

        public static int solution(int X, int[] A) {    //O(n)

            int earliestTime = -1;

            if(A.length < X) {
                return earliestTime;
            }

            Set<Integer> positionsOccured = new HashSet<>();
            for(int i = 0; i < A.length; i++) {
                positionsOccured.add(A[i]);
            }

            for(int i = 1; i < X + 1; i++) {
                if(!positionsOccured.contains(i)) {
                    return earliestTime;
                }
            }

            for(int i = 0; i < A.length; i++) {
                positionsOccured.remove(A[i]);
                if(positionsOccured.isEmpty()) {
                    earliestTime = i;
                    break;
                }
            }

            return earliestTime;
        }
}
