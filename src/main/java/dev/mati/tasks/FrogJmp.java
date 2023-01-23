package dev.mati.tasks;

public class FrogJmp {
    public static int solution(int X, int Y, int D) {
        int numOfJumps = 0;
        int distance = Y - X;
        if(distance%D != 0) {
            numOfJumps = distance/D + 1;
        } else {
            numOfJumps = distance/D;
        }
        return numOfJumps;
    }
}
