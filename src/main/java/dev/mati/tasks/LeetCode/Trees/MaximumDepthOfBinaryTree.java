package dev.mati.tasks.LeetCode.Trees;

import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {
    public static int rMaxDepthDFS(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Integer.max(rMaxDepthDFS(root.left), rMaxDepthDFS(root.right));

    }
    public static int iMaxDepthBFS(TreeNode root) {
        if(root == null)
            return 0;
        int level = 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            while(!que.isEmpty()) {
                TreeNode node = que.poll();
                if(node.left != null)
                    nextLevel.offer(node.left);
                if(node.right != null)
                    nextLevel.offer(node.right);
            }
            que = nextLevel;
            level++;
        }

        return level;
    }
}
