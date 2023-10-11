package dev.mati.tasks.LeetCode.Trees;

import java.util.LinkedList;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(1,2,3,4,5);
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {    //O(n)  in time and space
        int[] diameter = new int[1];
        getHeightFrom(root, diameter);
        return diameter[0];
    }
    public static int getHeightFrom(TreeNode root, int[] diameter) {
        if(root == null)
            return 0;
        int lH = getHeightFrom(root.left, diameter);
        int rH = getHeightFrom(root.right, diameter);
        diameter[0] = Integer.max(diameter[0], lH + rH);

        return 1 + Integer.max(lH, rH);
    }
    public static int diameterOfBinaryTreeBF(TreeNode root) { // O(n^2)
        int maxDiam = 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
            int lDesc = countDescendants(node.left);
            int rDesc = countDescendants(node.right);
            int currDiam = lDesc - 1 + rDesc - 1 + 2;
            maxDiam = Integer.max(maxDiam, currDiam);
        }
        return maxDiam;
    }
    public static int countDescendants(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Integer.max(countDescendants(root.left), countDescendants(root.right));
    }
}
