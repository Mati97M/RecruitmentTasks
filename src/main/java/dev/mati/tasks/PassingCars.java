package dev.mati.tasks;

public class PassingCars {
    public static int perfectSolution(int[] A) {
        int passingCars = 0;
        int pairs = 0;

        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] == 1) {
                pairs++;
            } else {
                passingCars += pairs;
                if (passingCars > 1_000_000_000)
                    return -1;
            }

        }
        return passingCars;
    }

    public static int bruteForceSolution(int[] A) {   //brute force 0% performance
        int passingCars = 0;
        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] == 0) {
                for(int j = i + 1; j < A.length; j++) {
                    if(A[j] == 1) {
                        passingCars++;
                        if(passingCars > 1_000_000_000) {
                            return -1;
                        }
                    }
                }
            }
        }
        return passingCars;
    }
}
