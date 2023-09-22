package dev.mati.tasks.LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {
        Node head = Node.getHead(new int[]{7, -1}, new int[]{13, 0}, new int[]{11, 4}, new int[]{10, 2}, new int[]{1, 0});
        Node.printNodes(copyRandomList(head));
    }
    public static Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node,Node> oldToCopy = new HashMap<>();
        while(curr != null) {
            Node copy = new Node(curr.val);
            oldToCopy.put(curr,copy);
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            Node copy = oldToCopy.get(curr);
            copy.next = oldToCopy.get(curr.next);
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;
        }

        return oldToCopy.get(head);
    }
    public static Node copyRandomListDummy(Node head) {
        if(head == null)
            return null;

        Node dummy = new Node(0);
        Node tail = dummy;
        Node curr = head;
        Map<Node,Node> oldToCopy = new HashMap<>();
        while(curr != null) {
            Node temp = new Node(curr.val);
            oldToCopy.put(curr,temp);
            tail.next = temp;
            tail = tail.next;
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            Node copy = oldToCopy.get(curr);
            copy.random = oldToCopy.get(curr.random);
            curr = curr.next;
        }

        return dummy.next;
    }
}
