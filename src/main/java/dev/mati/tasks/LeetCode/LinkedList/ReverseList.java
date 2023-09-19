package dev.mati.tasks.LeetCode.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static dev.mati.tasks.LeetCode.LinkedList.ListNode.printNodeList;

public class ReverseList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ArrayList<ListNode> list = new ArrayList<>();
        for (int el: arr) {
            list.add(new ListNode(el));
        }
        for(int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        System.out.println(Arrays.toString(arr));
        printNodeList(reverseList(list.get(0)));
    }
    public static ListNode reverseList2(ListNode head) {
        Stack<Integer> nodeStack =  new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            nodeStack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            curr.val = nodeStack.pop();
            curr = curr.next;
        }
        return head;

    }
    public static ListNode reverseList(ListNode head) {     //iterative approach
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;

    }
}

