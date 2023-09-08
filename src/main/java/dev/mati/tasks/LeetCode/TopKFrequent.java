package dev.mati.tasks.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
       int[] kMostFrequent = new int[k];
       Map<Integer, Integer> valsIndices = new HashMap<>();
       for(int i = 0; i < nums.length; i++ ) {
           valsIndices.put(nums[i],valsIndices.getOrDefault(nums[i],0) + 1);
       }
       Map<Integer,Integer> mostFrequent = valsIndices.entrySet()
               .stream()
               .sorted(Map.Entry.comparingByValue(
                       (a,b) -> -Integer.compare(a,b)
               ))
               .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (oldValue, newValue) -> oldValue, LinkedHashMap::new));

       int index = 0;
       for(int key: mostFrequent.keySet()) {
           if(index >= k)
               break;
           kMostFrequent[index] = key;
           index++;
       }
       return kMostFrequent;
   }
}
