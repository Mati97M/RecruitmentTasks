package dev.mati.tasks;

import java.util.ArrayList;
import java.util.TreeMap;

public class ReduceDifference {
    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 5, 10, 5, 3, 7};
        System.out.println("Difference after applying function: " + reduceDiff(arr));
    }

    private static int reduceDiff(int[] arr) {
        int remaining = arr[0];
        TreeMap<Integer, ArrayList<Integer>> wfNumIndexes = new TreeMap<>();
        for(int i = 1; i < arr.length; i++) {
            if(!wfNumIndexes.containsKey(arr[i]))
                wfNumIndexes.put(arr[i],new ArrayList<>());
            wfNumIndexes.get(arr[i]).add(i);
        }
        int lowest = wfNumIndexes.firstKey();
        for(var key: wfNumIndexes.keySet()) {
            int size = wfNumIndexes.get(key).size();
            if(remaining <= 0 || remaining < size)
                break;
            remaining -= size;
            if(wfNumIndexes.containsKey(key + 1)) {
                while (size-- > 0)
                    wfNumIndexes.get(key + 1).add(key + 1);
            }
            lowest++;
        }
        return wfNumIndexes.lastKey() - lowest;
    }

}
