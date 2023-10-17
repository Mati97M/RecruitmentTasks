package dev.mati.tasks.LeetCode.ArraysHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        //a - z : 26 characters  , int[26] or a hashmap
        HashMap<String, LinkedList<String>> anagramsLists =
                new HashMap<String,LinkedList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] sortedChars =  strs[i].toCharArray();
            Arrays.sort(sortedChars);
            String sorted = new String(sortedChars);
            if(!anagramsLists.containsKey(sorted)) {
                anagramsLists.put(sorted,new LinkedList<String>());
            }
            anagramsLists.get(sorted).add(strs[i]);
        }
        return anagramsLists.values()
                .stream()
                .collect(Collectors.toList());
    }
}
