package dev.mati.tasks.LeetCode.LinkedList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode getNodes(int... elements) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int el: elements) {
            ListNode temp = new ListNode(el);
            tail.next = temp;
            tail = tail.next;
        }
        return dummy.next;
    }
    public static ListNode getNodesWithStream(int... elements) {
        if (elements.length == 0)
            return null;
        List<ListNode> nodeList = Arrays.stream(elements)
                .mapToObj(ListNode::new)
                .toList();

        Iterator<ListNode> it = nodeList.listIterator();
        ListNode prev = null;
        while(it.hasNext()) {
            if (prev == null) {
                prev = it.next();
            } else {
                ListNode curr = it.next();
                prev.next = curr;
                prev = curr;
            }
        }
        return nodeList.get(0);
    }
    public static void printNodeList(ListNode n) {
        if(n == null){
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while(n.next != null) {
            System.out.print("" + n.val +"," );
            n = n.next;
        }
        System.out.print(n.val);
        System.out.print("]\n");

    }
}
