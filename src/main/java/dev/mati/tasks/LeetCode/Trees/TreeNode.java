package dev.mati.tasks.LeetCode.Trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode getNodeFromBST(int target) {
        TreeNode curr = this;
        while(curr != null && curr.val != target) {
            if(curr.val < target)
                curr = curr.right;
            else
                curr = curr.left;
        }
        return curr;
    }

    public int getVal() {
        return val;
    }
}
