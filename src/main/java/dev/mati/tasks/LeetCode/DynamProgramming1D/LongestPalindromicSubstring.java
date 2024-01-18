package dev.mati.tasks.LeetCode.DynamProgramming1D;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxLength = 1;
        int start = 0;
        int end = 0;
        //odd
        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++) {
            l = i - 1;
            r = i + 1;
            int currLength = 1;
            while(l >= 0 && r < s.length() &&  s.charAt(l) == s.charAt(r)) {
                currLength += 2;
                l--;
                r++;
            }
            if(maxLength < currLength) {
                maxLength = currLength;
                start = l + 1;
                end = r - 1;
            }
        }

        //even
        for(int i = 0; i < s.length() - 1; i++) {
            l = i;
            r = i + 1;
            if(s.charAt(l) != s.charAt(r))
                continue;
            int currLength = 0;
            while(l >= 0 && r < s.length() &&  s.charAt(l) == s.charAt(r)) {
                currLength += 2;
                l--;
                r++;
            }
            if(maxLength < currLength) {
                maxLength = currLength;
                start = l + 1;
                end = r - 1;
            }
        }
        return s.substring(start, end + 1);
    }
}
