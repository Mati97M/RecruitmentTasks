package dev.mati.tasks.LeetCode.LinkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getNodes(2,4,3);
        ListNode l2 = ListNode.getNodes(5,6,4);
        ListNode.printNodeList(addTwoNumbers(l1,l2));
        System.out.println();

        l1 = ListNode.getNodes(9,9,9,9,9,9,9);
        l2 = ListNode.getNodes(9,9,9,9);
        ListNode.printNodeList(addTwoNumbers(l1,l2));
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int extra = 0;

        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 == null)
                sum += l2.val + extra;
            else if (l2 == null)
                sum += l1.val + extra;
            else
                sum = l1.val + l2.val + extra;
            if(sum > 9) {
                sum = sum - 10;
                extra = 1;

            } else {
                extra = 0;
            }
            ListNode nxt = new ListNode(sum);
            tail.next = nxt;
            tail = tail.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(extra != 0)
            tail.next = new ListNode(extra,null);

        return dummy.next;
    }
}
