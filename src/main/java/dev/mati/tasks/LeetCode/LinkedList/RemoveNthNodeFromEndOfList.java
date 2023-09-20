package dev.mati.tasks.LeetCode.LinkedList;

import java.util.ArrayList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head1 = ListNode.getNodes(1,2,3,4,5);
        int n = 2;
        ListNode.printNodeList(removeNthFromEnd(head1,n));
    }
    public static ListNode removeNthFromEndWithArr(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        int deletionIndex = nodes.size() - n;
        nodes.remove(deletionIndex);
        for(int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        if(nodes.size() > 0) {
            nodes.get(nodes.size() - 1).next = null;
            return nodes.get(0);
        } else {
            return null;
        }
    }
    public static ListNode removeNthFromEndWithReverse(ListNode head, int n) {
        if(head.next==null && n==1)
            return null;

        ListNode reversedHead = reverseList(head);
        if(n == 1) {
            reversedHead = reversedHead.next;
            return reverseList(reversedHead);
        }

        ListNode curr = reversedHead;
        ListNode prev = null;
        while(n > 1) {
            n--;
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return reverseList(reversedHead);
    }
    public static ListNode reverseList(ListNode head) {
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode left = dummy;
        ListNode rigth = head;
        while(n-- > 0)
            rigth = rigth.next;
        while(rigth != null) {
            rigth = rigth.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
