package dev.mati.tasks.LeetCode;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
   /* private static int[] topKFrequent(int[] nums, int k) {
        int[] kMostFrequent = new int[k];
        Map<Integer, Integer> valsIndices = new HashMap<>();
        for(int i = 0; i < nums.length; i++ ) {
            valsIndices.put(nums[i],valsIndices.getOrDefault(nums[i],0) + 1);
        }
        var frequencies = new ArrayList<LinkedList<Integer>>(Collections.nCopies(nums.length + 1,null));
        Collections.fill(frequencies,null);

        for(int key: valsIndices.keySet()) {
            if(frequencies.get(valsIndices.get(key)) == null)
                frequencies.set(valsIndices.get(key),new LinkedList<Integer>());
            frequencies.get(valsIndices.get(key)).add(key);
        }
        for(int i = frequencies.size() - 1; i >= 0 && k > 0; i--) {
            if(frequencies.get(i) != null) {
                for(int el: frequencies.get(i)) {
                    k--;
                    kMostFrequent[k] = el;
                    if(k == 0)
                        break;
                }
            }
        }
        return kMostFrequent;
    }*/
   public static int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> frequencies = new HashMap<>();
       for(int i = 0; i < nums.length; i++ ) {
           frequencies.put(nums[i],frequencies.getOrDefault(nums[i],0) + 1);
       }
       Integer[] kMostFrequent = frequencies.entrySet()
               .stream()
                   .sorted(Map.Entry.comparingByValue(
                           (a,b) -> -Integer.compare(a,b)
                   ))
                   .limit(k)
                   .map(
                           entry -> entry.getKey()
                   )
                   .toArray(Integer[]::new);
       int[] result = new int[k];
       for (int i = 0; i < result.length; i++) {
           result[i] = kMostFrequent[i];
       }
       return result;
   }
}
