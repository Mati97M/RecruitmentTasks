package dev.mati.tasks.LeetCode.TwoPointers;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome1(s));
    }
    public static boolean isPalindrome1(String s) { //faster
        int start = 0;
        int end = s.length() - 1;

        while(start <= end) {
            Character a = s.charAt(start);
            Character z = s.charAt(end);
            if(!Character.isLetterOrDigit(a)) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(z)) {
                end--;
                continue;
            }
            if(Character.compare(Character.toLowerCase(a),Character.toLowerCase(z)) != 0) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean isPalindrome2(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]+","");
        int start = 0;
        int end = str.length() - 1;
        for(;start <= end; start++, end--) {
            if(Character.compare(str.charAt(start), str.charAt(end)) != 0) {
                return false;
            }
        }
        return true;
    }
}
