package dev.mati.tasks.LeetCode.LinkedList;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = ListNode.getNodes(1,2,4);
        ListNode list2 = ListNode.getNodes(1,3,4);
        ListNode.printNodeList(list1);
        ListNode.printNodeList(list2);
        ListNode.printNodeList(mergeTwoLists2(list1,list2));
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if(list1 == null && list2 != null)
            return list2;
        if(list1 != null && list2 == null)
            return list1;


        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode prev = null;

        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                if(prev != null) {
                    prev.next = curr1;
                }
                prev = curr1;
                curr1 = curr1.next;

            } else {
                if(prev != null) {
                    prev.next = curr2;
                }
                prev = curr2;
                curr2 = curr2.next;
            }

        }
        if(curr1 == null)
            prev.next = curr2;
        else if(curr2 == null)
            prev.next = curr1;

        if(list1.val <= list2.val)
            return list1;
        else
            return list2;
    }
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // edge cases are not the problem anymore
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                tail.next = curr1;
                curr1 = curr1.next;
            } else {
                tail.next = curr2;
                curr2 = curr2.next;
            }
            tail = tail.next;
        }
        if(curr1 == null)
            tail.next = curr2;
        else if(curr2 == null)
            tail.next = curr1;

        return dummy.next;
    }
}
