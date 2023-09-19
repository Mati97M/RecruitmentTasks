package dev.mati.tasks.LeetCode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head1 = ListNode.getNodes(1);
        ListNode.makeCycle(head1,1);
        System.out.println(hasCycle(head1));

        ListNode head2 = ListNode.getNodes(3,2,0,-4);
        ListNode.makeCycle(head2,1);
        System.out.println(hasCycle(head2));

    }
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while(head != null) {
            if(!nodes.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

}
