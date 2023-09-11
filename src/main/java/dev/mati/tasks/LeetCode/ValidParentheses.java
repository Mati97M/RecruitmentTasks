package dev.mati.tasks.LeetCode;

import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        String parentheses = "()[]{}";
        System.out.println(isValid(parentheses));
    }
    public static boolean isValid(String s) {
        LinkedList<Character> openBrackets = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char currBracket = s.charAt(i);
            if(currBracket == '(' ||
                    currBracket == '{' ||
                    currBracket == '[') {
                openBrackets.push(currBracket);
            } else {
                if(openBrackets.isEmpty())
                    return false;
                char lastOpen = openBrackets.pop();
                switch(lastOpen) {
                    case '(':
                        if(currBracket != ')')
                            return false;
                        break;
                    case '{':
                        if(currBracket != '}')
                            return false;
                        break;
                    case '[':
                        if(currBracket != ']')
                            return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        if(openBrackets.isEmpty())
            return true;
        else
            return false;
    }
}
