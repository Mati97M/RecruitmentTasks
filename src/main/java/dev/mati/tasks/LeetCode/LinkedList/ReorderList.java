package dev.mati.tasks.LeetCode.LinkedList;

import java.util.Stack;

public class ReorderList {
    public static void main(String[] args) {
        ListNode head1 = ListNode.getNodes(1,2,3,4);
        ListNode.printNodeList(head1);
        reorderListStack(head1);
        ListNode.printNodeList(head1);

        System.out.println();
        ListNode head2 = ListNode.getNodes(0,1,2,3,4,5,6,7,8,9);
        ListNode.printNodeList(head2);
        reorderListStack(head2);
        ListNode.printNodeList(head2);

        System.out.println();
        ListNode head3 = ListNode.getNodes(0,1,2,3,4);
        ListNode.printNodeList(head3);
        reorderListStack(head3);
        ListNode.printNodeList(head3);
    }
    public static void reorderListStack(ListNode head) { //memory O(n), Time O(n)
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        int nodesToInsert = stack.size()/2;
        while(nodesToInsert > 0) {
            ListNode nxt = curr.next;
            curr.next = stack.pop();
            curr.next.next = nxt;
            curr = nxt;
            nodesToInsert--;
        }
        curr.next =  null;
    }
}
