package dev.mati.tasks.LeetCode.LinkedList;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.getNodes(1,4,5);
        lists[1] = ListNode.getNodes(1,3,4);
        lists[2] = ListNode.getNodes(2,6);
        ListNode.printNodeList(mergeKLists(lists));


        lists = new ListNode[2];
        lists[0] = null;
        lists[1] = ListNode.getNodes(1);
        ListNode.printNodeList(mergeKLists(lists));
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        ListNode list1 = lists[0];
        ListNode list2 = null;

        for(int i = 1; i < lists.length; i++) {
            list2 = lists[i];
            list1 = merge(list1,list2);
        }
        return list1;

    }
    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }
        return dummy.next;
    }
    public static  ListNode mergeKListsNightmare(ListNode[] lists) { //O(m x n ), where m = lists.length
        if(lists.length == 0)
            return null;

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(tail != null) {
            ListNode min = lists[0];
            int j = 0;
            for(int i = 1; i < lists.length; i++) {
                if(lists[i] == null)
                    continue;
                if((min == null) || (min.val >= lists[i].val)) {
                    min = lists[i];
                    j = i;
                }
            }
            tail.next = min;
            tail = min;
            if(lists[j] != null)
                lists[j] = lists[j].next;
        }
        return dummy.next;
    }
}
