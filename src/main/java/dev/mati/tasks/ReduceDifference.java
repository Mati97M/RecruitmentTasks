package dev.mati.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class ReduceDifference {
    public static void main(String[] args) {
        int[] arr = {8, 4, 6, 5, 10, 5, 3, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println("Difference after applying function: " + reduceDiff(arr));
        System.out.println(Arrays.toString(arr));

        System.out.println();

        arr = new int[] {8, 2, 2, 1, 8, 5, 4, 3, 1, 2, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println("Difference after applying function: " + reduceDiff(arr));
        System.out.println(Arrays.toString(arr));

    }

    private static int reduceDiff(int[] arr) {
        int remaining = arr[0];
        TreeMap<Integer, ArrayList<Integer>> wfNumIndexes = new TreeMap<>();

        for(int i = 1; i < arr.length; i++) {
            if(!wfNumIndexes.containsKey(arr[i]))
                wfNumIndexes.put(arr[i],new ArrayList<>());
            wfNumIndexes.get(arr[i]).add(i);
        }

        int size = 0;
        int lowest = wfNumIndexes.firstKey();

        HashMap<Integer, ArrayList<Integer>> updatedIndexes = new HashMap<>();
        int lowestVals = 0;
        updatedIndexes.put(lowestVals, new ArrayList<>());
        int sndLowestVals = 1;
        updatedIndexes.put(sndLowestVals, new ArrayList<>());    //-2 as key to the last updated elements, val ->  lowest + 1

        for(var key: wfNumIndexes.keySet()) {
            size = wfNumIndexes.get(key).size() + updatedIndexes.get(lowestVals).size();
            if(remaining <= 0)
                break;
            if(remaining < size) {
                for(int i = 0; i < remaining; i++)
                    updatedIndexes.get(sndLowestVals).add(wfNumIndexes.get(key).get(i));
            } else {
                updatedIndexes.get(lowestVals).addAll(wfNumIndexes.get(key));
                lowest++;
            }
            remaining -= size;
        }
        for(int index: updatedIndexes.get(lowestVals))
            arr[index] = lowest;
        for(int index: updatedIndexes.get(sndLowestVals))
            arr[index] = lowest + 1;

        return wfNumIndexes.lastKey() - lowest;
    }

}
