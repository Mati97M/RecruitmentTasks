package dev.mati.tasks.LeetCode.Trees;

import java.util.LinkedList;

public class TreePrinter {
    public static void printAsArr(TreeNode root) {//to be upgrated -> count the levels -> for printing nulls
        if(root == null) {
            System.out.println("null");
            return;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<Integer> nodeVals = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            que.offer(root.left);
            que.offer(root.right);
            nodeVals.add(que.pop().val);
            root = que.peek();
            if(root == null)
                break;
        }
        System.out.println(nodeVals);
    }
}
