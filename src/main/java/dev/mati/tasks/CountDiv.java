package dev.mati.tasks;

public class CountDiv {

    public static int perfectSolution(int A, int B, int K) {    // 100% O(1)
        if(K > B){
            if(A == 0 && B == 0) {
                return 1;
            }
            return 0;
        }else
        if(K == B) {
            if(A == 0) {
                return 2;
            }
            return 1;
        }
        int restA = A%K;
        int restB = B%K;
        if(restB != 0) {
            B -= restB;
        }
        if(restA != 0) {
            A += K - restA;
        }

        return (B - A)/K + 1;
    }

    public static int solution(int A, int B, int K) {  //brute force, performance 0%  O(B-A)
        int divisibleByK = 0;

        for(int i = A; i <= B; i++) {
            if(i%K == 0) {
                divisibleByK++;
            }
        }

        return divisibleByK;
    }
}
