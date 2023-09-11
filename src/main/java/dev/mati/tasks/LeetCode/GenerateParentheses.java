package dev.mati.tasks.LeetCode;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    private StringBuilder seq = new StringBuilder();
    private List<String> result = new LinkedList<String>();

    public static void main(String[] args) {
        var parenthesisGenerator = new GenerateParentheses();
        parenthesisGenerator.generateParenthesis(4)
                .forEach(System.out::println);
    }
    public List<String> generateParenthesis(int n) {
        generateSequenceRcsv(n, 0, 0);
        return result;
    }
    private void generateSequenceRcsv(int n, int openN, int closedN) {
        if(openN == n && openN == closedN) {
            result.add(seq.toString());
            return;
        }
        if(openN < n) {
            seq.append('(');
            generateSequenceRcsv(n, openN + 1, closedN);
            seq.deleteCharAt(seq.length() - 1);
        }
        if(closedN < openN) {
            seq.append(')');
            generateSequenceRcsv(n, openN, closedN + 1);
            seq.deleteCharAt(seq.length() - 1);
        }
    }
}
