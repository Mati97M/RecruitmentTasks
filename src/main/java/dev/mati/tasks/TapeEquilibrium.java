package dev.mati.tasks;

public class TapeEquilibrium {
    public static void main(String[] args) {
        System.out.println(bestSolution(new int[] {3,1}));
    }
    public static int bestSolution(int[] A) {   //O(n)

        int P = 1;
        int minimalDiff = Integer.MAX_VALUE;

        int firstHalf = 0;
        for (int f = 0; f < P; f++) {
            firstHalf += A[f];
        }

        int secHalf = 0;
        for(int s = P; s < A.length; s++) {
            secHalf += A[s];
        }

        do {
            int tempDiff = firstHalf - secHalf;
            tempDiff  = tempDiff < 0 ? -tempDiff : tempDiff;

            if (minimalDiff > tempDiff) {
                minimalDiff = tempDiff;
            }
            P++;
            if(P < A.length) {
                firstHalf += A[P - 1];
                secHalf -= A[P - 1];
            } else {
                break;
            }
        } while(true);

        return minimalDiff;
    }

    public static int bestUglySolution(int[] A) {       //O(n)

        int P = 1;
        int minimalDiff = Integer.MAX_VALUE;
        int firstHalf = 0;
        for (int f = 0; f < P; f++) {
            firstHalf += A[f];
        }

        int secHalf = 0;
        for(int s = P; s < A.length; s++) {
            secHalf += A[s];
        }

        int tempDiff = firstHalf - secHalf;
        tempDiff  = tempDiff < 0 ? -tempDiff : tempDiff;

        if (minimalDiff > tempDiff) {
            minimalDiff = tempDiff;
        }

        for(; P < A.length - 1; P++) {

            firstHalf += A[P];
            secHalf -= A[P];
            tempDiff = firstHalf - secHalf;
            tempDiff  = tempDiff < 0 ? -tempDiff : tempDiff;

            if (minimalDiff > tempDiff) {
                minimalDiff = tempDiff;
            }
        }
        return minimalDiff;
    }

    public static int solution(int[] A) {  // solution N**2 :(

        int minimalDiff = Integer.MAX_VALUE;

        for(int P = 1; P < A.length; P++) {

            int firstHalf = 0;
            for (int f = 0; f < P; f++) {
                firstHalf += A[f];
            }

            int secHalf = 0;
            for(int s = P; s < A.length; s++) {
                secHalf += A[s];
            }

            int tempDiff = firstHalf - secHalf;
            tempDiff  = tempDiff < 0 ? -tempDiff : tempDiff;

            if (minimalDiff > tempDiff) {
                minimalDiff = tempDiff;
            }
        }
        return minimalDiff;
    }
}
