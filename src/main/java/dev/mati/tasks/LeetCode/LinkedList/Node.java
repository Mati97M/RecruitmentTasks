package dev.mati.tasks.LeetCode.LinkedList;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
    public static Node getHead(int[]... nodes) {
        if(nodes.length == 0)
            return null;

        Node dummy = new Node(0);
        Node tail = dummy;
        Node[] randoms = new Node[nodes.length];
        for(int i = 0; i < nodes.length; i++) {
            Node temp = new Node(nodes[i][0]);
            tail.next = temp;
            randoms[i] = temp;
            tail = tail.next;
        }
        Node curr = dummy.next;
        for(int i = 0; i < nodes.length; i++) {
             if (nodes[i][1] < 0)
                 curr.random = null;
             else {
                 curr.random = randoms[i];
             }
            curr = curr.next;
        }

        return dummy.next;
    }
    public static void printNodes(Node head) {
        Node curr = head;
        System.out.print("[ ");
        while(curr != null) {
            System.out.printf("[%d] ", curr.val);
            curr = curr.next;
        }
        System.out.print(" ]");

    }
}
