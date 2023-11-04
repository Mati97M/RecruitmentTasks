package dev.mati.tasks.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    private LinkedList<String> cs = new LinkedList<String>();

    public static void main(String[] args) {
        String s = "234";
        LetterCombinationsPhoneNumber l = new LetterCombinationsPhoneNumber();
        System.out.println(l.letterCombinations(s));

    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        ArrayList<String> groups = extractLetterGroups(digits);
        generateCs(groups, 0, new StringBuilder());
        return cs;
    }
    private void generateCs(ArrayList<String> groups, int i, StringBuilder c) {
        if(i == groups.size()) {
            cs.add(c.toString());
            return;
        }
        for(char letter: groups.get(i).toCharArray()) {
            c.append(letter);
            generateCs(groups, i + 1, c);
            c.deleteCharAt(c.length() - 1);
        }
    }

    private ArrayList<String> extractLetterGroups(String s) {
        ArrayList<String> groups = new ArrayList<>(s.length());
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '2':
                    groups.add("abc");
                    break;
                case '3':
                    groups.add("def");
                    break;
                case '4':
                    groups.add("ghi");
                    break;
                case '5':
                    groups.add("jkl");
                    break;
                case '6':
                    groups.add("mno");
                    break;
                case '7':
                    groups.add("pqrs");
                    break;
                case '8':
                    groups.add("tuv");
                    break;
                case '9':
                    groups.add("wxyz");
                    break;
                default:
                    break;
            }
        }
        return groups;
    }
}
