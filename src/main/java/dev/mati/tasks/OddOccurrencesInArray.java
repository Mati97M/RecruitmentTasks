package dev.mati.tasks;

import java.util.ArrayList;
import java.util.Hashtable;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] arr = {9,3,9,3,9,7,9};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {   //best , perfect score :)  Radi ma lepsze
        // Detected time complexity: O(N) or O(N*log(N))
        Hashtable<Integer,Integer> numbers = new Hashtable<>();
        for (int i = 0; i < A.length; i++) {
            Integer key = A[i];
            Integer prevVal = numbers.get(A[i]);
            if(prevVal == null) {
                Integer val = 1;
                numbers.put(key,val);
            } else {
                numbers.put(key,prevVal + 1);
            }
        }
        int uniqueNum = -1;
        for(Integer key: numbers.keySet()) {
            if(numbers.get(key) % 2 != 0) {
                uniqueNum = key;
            }
        }
        return uniqueNum;
    }

    public static int solution2(int[] A) { //ok, ale N**2  niby, brute force
        ArrayList<Integer> unpaired = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if(!unpaired.contains(A[i])) {
                unpaired.add(A[i]);
            } else {
                unpaired.remove(Integer.valueOf(A[i]));
            }
        }
        return unpaired.get(0);
    }
}
