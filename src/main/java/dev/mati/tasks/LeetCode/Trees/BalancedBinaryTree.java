package dev.mati.tasks.LeetCode.Trees;

public class BalancedBinaryTree {
    private boolean isBalanced = true;
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(1);
        System.out.println(new BalancedBinaryTree().isBalanced(root));

        root = TreeBuilder.getTreeFromArr(3,9,20,null,null,15,7);
        System.out.println(new BalancedBinaryTree().isBalanced(root));


        root = TreeBuilder.getTreeFromArr(1,2,2,3,3,null,null,4,4);
        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }
    ///////////
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        getHeightDFS(root);
        return isBalanced;
    }
    private int getHeightDFS(TreeNode root) {
        if(root == null) return 0;
        int lH = getHeightDFS(root.left);
        int rH = getHeightDFS(root.right);
        areBalanced(lH, rH);
        return 1 + Integer.max(lH, rH);
    }
    private void areBalanced(int h1, int h2) {
        isBalanced = Math.abs(h1 - h2) <= 1 &&  isBalanced;
    }
}
