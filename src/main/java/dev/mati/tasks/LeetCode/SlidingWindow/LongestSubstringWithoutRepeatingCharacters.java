package dev.mati.tasks.LeetCode.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.printf("lengthOfLongestSubstring: %s is: %d%n",s,lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.printf("lengthOfLongestSubstring: %s is: %d%n",s,lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.printf("lengthOfLongestSubstring: %s is: %d%n",s,lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int l = 0;
        int r = 0;
        int maxLength = 0;
        Set<Character> characters = new HashSet<Character>();
        while(r < s.length()) {
            if(characters.add(s.charAt(r))) {
                maxLength = Integer.max(maxLength,characters.size());
                r++;
            } else {
                while(characters.contains(s.charAt(r))) {
                    characters.remove(s.charAt(l));
                    l++;
                }

            }
        }
        return maxLength;
    }
}
