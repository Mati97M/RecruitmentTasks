package dev.mati.tasks.LeetCode;

import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> elements;
    private LinkedList<Integer> minVals;

    public MinStack() {
        elements = new LinkedList<Integer>();
        minVals = new LinkedList<Integer>();
    }

    public void push(int val) {
        elements.push(val);
        if(!minVals.isEmpty()) {
            int min = minVals.peekFirst();
            val = Math.min(min,val);
        }

        minVals.push(val);
    }

    public void pop() {
        elements.pop();
        minVals.pop();
    }

    public int top() {
        return elements.peekFirst();
    }

    public int getMin() {
        return minVals.peekFirst();
    }
}
