package dev.mati.tasks;

import java.util.HashMap;

public class TheShortestUniqueSequence {
    public static void main(String[] args) {
        System.out.println(solution("zyzyzyz")); //100% OK
    }
    public static int solution(String S) {
        int res = 1;
        while(res <= S.length()) {
            HashMap<String, Integer> subStrings = new HashMap<>();
            for (int i = 0; i < S.length(); i++) {
                if(i + res > S.length())
                    break;
                String substr = S.substring(i,i + res);
                subStrings.put(substr, subStrings.getOrDefault(substr, 0) + 1);
            }
            if(subStrings.values().contains(1))
                break;
            else {
                res++;
            }
        }
        return res;
    }

}
