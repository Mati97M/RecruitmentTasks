package dev.mati.tasks;

public class GenomicRangeQuery {
    public static int[] solution(String S, int[] P, int[] Q) { //62%  correctness 100%, performance 0&
        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i];
            int minImpact = 5;

            while(start != end + 1) {
                int currImpact = minImpact;
                switch(S.charAt(start)) {
                    case 'A':
                        currImpact = 1;
                        break;
                    case 'C':
                        currImpact = 2;
                        break;
                    case 'G':
                        currImpact = 3;
                        break;
                    case 'T':
                        currImpact = 4;
                        break;
                }
                minImpact = Math.min(currImpact,minImpact);
                start++;
            }
            result[i] = minImpact;
        }
        return result;
    }
}
