package dev.mati.tasks.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    private LinkedList<List<String>> partitions = new LinkedList<List<String>>();

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition("aab"));
    }
    public List<List<String>> partition(String s) {
        generatePartitions(s, new LinkedList<String>());
        return partitions;
    }
    private void generatePartitions(String s, LinkedList<String> p) {
        if(s.length() == 0) {
            partitions.add(new ArrayList<>(p));
            return;
        }
        for(int j = 0; j < s.length(); j++) {
            if(isPalindrome(s, j)) {
                p.addLast(s.substring(0, j + 1));
                generatePartitions(s.substring(j + 1), p);
                p.removeLast();
            }
        }
    }
    private boolean isPalindrome(String s, int end) {
        int l = 0;
        int r = end;

        while(l <= r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(lc != rc)
                return false;
            l++;
            r--;
        }
        return true;
    }
}
