package dev.mati.tasks.LeetCode.LinkedList;

import java.util.ArrayList;

public class ReverseNodesInKGroup {// for improvement: O(1) in memory
    public static void main(String[] args) {
        ListNode head = ListNode.getNodes(1,2,3,4,5);
        ListNode.printNodeList(reverseKGroup(head,2));
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode resultHead = null;
        ListNode start = head;
        ListNode end = start;
        int i = 0;
        ArrayList<ListNode> heads = new ArrayList<>();
        while(true) {
            while(end != null && i < k) {
                end = end.next;
                i++;
            }
            if(i == k) {
                ListNode temp = reverse(start,end);
                if(resultHead == null)
                    resultHead = temp;
                start = end;
                heads.add(temp);
            } else
                break;
            i = 0;
        }
        ListNode last = null;
        for(int h = 0; h < heads.size(); h++) {
            ListNode curr = heads.get(h);
            if(last != null)
                last.next = curr;
            while (curr.next != null) {
                curr = curr.next;
            }
            last = curr;
        }
        last.next = start;
        return resultHead;

    }
    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        while(curr != null && curr != end) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
