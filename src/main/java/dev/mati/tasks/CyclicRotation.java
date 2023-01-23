package dev.mati.tasks;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        int[] arr1 = {3, 8, 9, 7, 6};
        int[] arr2 = {3, 8, 9, 7, 6};
        int[] arr3 = {3, 8, 9, 7, 6};

        System.out.println(Arrays.toString(
                solution(arr1,3))
                );
        System.out.println(Arrays.toString(
                solutionIter(arr2,3))
        );
        System.out.println(Arrays.toString(
                solutionR(arr3,3))
        );
    }
    public static int[] solution(int[] A, int K) {  //ok
        int aLength = A.length;
        if(aLength == 0) {
            return A;
        }

        int realShiftingNumber = K%(aLength);
        int[] shiftedArr = new int[aLength];
        for (int i = aLength - realShiftingNumber, j = 0; i < aLength; i++, j++) {
            shiftedArr[j] = A[i];
        }
        for (int i = 0, j = realShiftingNumber; j < aLength; i++, j++)      {
            shiftedArr[j] = A[i];
        }

        return shiftedArr;
    }
    public static int[] solutionIter(int[] A, int K) {  //ok
        int aLength = A.length;
        if(aLength == 0) {
            return A;
        }
        int realShiftingNumber = K%(aLength);

        while (realShiftingNumber > 0) {
            int temp = A[aLength - 1];
            for (int i = aLength - 1; i > 0; i-- ) {
                A[i] = A[i - 1];
            }
            A[0] = temp;
            realShiftingNumber--;
        }
        return A;
    }

    public static int[] solutionR(int[] A, int K) { //runtime Error

        int aLength = A.length;
        int realShiftingNumber = K%(aLength);

        if (K == 0 || aLength == 0) {
            return A;
        } else {
            int temp = A[aLength - 1];
            for (int i = aLength - 1; i > 0; i-- ) {
                A[i] = A[i - 1];
            }
            A[0] = temp;
            realShiftingNumber--;

        }
        return solutionR(A,realShiftingNumber);
    }
}