package dev.mati.tasks.LeetCode.Stack;

import java.util.LinkedList;

public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> expression = new LinkedList<Integer>();
        int opR = 0;
        int opL = 0;
        for (String token: tokens) {
            switch(token) {
                case "+":
                    opR = expression.pop();
                    opL = expression.pop();
                    expression.push(opR + opL);
                    break;
                case "-":
                    opR = expression.pop();
                    opL = expression.pop();
                    expression.push(opR - opL);
                    break;
                case "*":
                    opR = expression.pop();
                    opL = expression.pop();
                    expression.push(opR * opL);
                    break;
                case "/":
                    opR = expression.pop();
                    opL = expression.pop();
                    expression.push(opL / opR);
                    break;
                default:
                    expression.push(Integer.valueOf(token));
            }
        }
        return expression.pop();
    }
}
