package dev.mati.tasks.LeetCode.DynamProgramming1D;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        //odd
        int count = 0;
        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++) {
            l = i;
            r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        //even
        for(int i = 0; i < s.length() - 1; i++) {
            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
