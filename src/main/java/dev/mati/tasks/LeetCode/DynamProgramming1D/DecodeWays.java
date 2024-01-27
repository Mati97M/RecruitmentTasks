package dev.mati.tasks.LeetCode.DynamProgramming1D;

import java.util.HashMap;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("27"));
    }
    private HashMap<String, Integer> cache = new HashMap<>();
    public int numDecodings(String s) {
        return f(s, 0);
    }
    private int f(final String s, int i) {
        if(i < s.length() && cache.containsKey(s.substring(i)))
            return cache.get(s.substring(i));

        if(i > s.length()) {
            return 0;
        }
        if(i == s.length())
            return 1;
        int fst = Character.getNumericValue(s.charAt(i));
        int sec = -1;
        if(fst == 0)
            return 0;
        if(i + 1 < s.length()) {
            sec = Character.getNumericValue(s.charAt(i + 1));
        }
        if((sec != -1 && 10 * fst + sec > 26)) {
            int res = 0 + f(s, i + 1);
            cache.put(s.substring(i), res);
            return res;
        }
        int res = f(s, i + 1) + f(s, i + 2);
        cache.put(s.substring(i), res);
        return res;
    }
    // private int[] initTable() {
    //     table = new char[26 + 1];
    //     for(int i = 0; i < 26; i++) {
    //         table[i + 1] = (char) ('A' + i);
    //     }
    //     return table;
    // }
}
