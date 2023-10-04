package dev.mati.tasks.LeetCode.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> frequencies = new HashMap<>();
        int l = 0;
        int r = 0;
        int result = 1;

        while(r < s.length()) {
            frequencies.put(s.charAt(r),
                    frequencies.getOrDefault(s.charAt(r),0) + 1);
            r++;
            int wSize = r - l;
            int maxFreq = Collections.max(frequencies.values());
            if(wSize - maxFreq <= k) {
                result = Integer.max(result,wSize);
            } else {
                while(wSize - maxFreq > k) {
                    frequencies.put(s.charAt(l),
                            frequencies.get(s.charAt(l)) - 1);
                    l++;
                    wSize = r - l;
                    maxFreq = Collections.max(frequencies.values());
                }
            }
        }
        return result;
    }
}
