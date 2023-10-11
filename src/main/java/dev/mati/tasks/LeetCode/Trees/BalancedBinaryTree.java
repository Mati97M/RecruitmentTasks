package dev.mati.tasks.LeetCode.Trees;

public class BalancedBinaryTree {
    private static boolean isBalanced = true;

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(1);
        System.out.println(isBalanced(root));

        root = TreeBuilder.getTreeFromArr(3,9,20,null,null,15,7);
        System.out.println(isBalanced(root));

        root = TreeBuilder.getTreeFromArr(1,2,2,3,3,null,null,4,4);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        boolean[] balanced = {true};
        dfsBalanced(root, balanced);
        return balanced[0];
    }
    public static int dfsBalanced(TreeNode root,  boolean[] balanced) {
        if(root.left == null && root.right == null)
            return 1;

        int left = 0;
        int right = 0;

        if(root.left != null)
            left = dfsBalanced(root.left, balanced);
        if(root.right != null)
            right = dfsBalanced(root.right, balanced);

        if(Math.abs(left - right) > 1)
            balanced[0] = false;

        return 1 + Integer.max(left,right);

    }
    public static boolean isBalanced2(TreeNode root) { //leetcode gives different result for [1]
        if(root == null)
            return true;
        dfsBalanced(root);
        return isBalanced;
    }
    public static int dfsBalanced(TreeNode root) { //leetcode gives different result for [1]
        if(root.left == null && root.right == null)
            return 1;

        int left = 0;
        int right = 0;

        if(root.left != null)
            left = dfsBalanced(root.left);
        if(root.right != null)
            right = dfsBalanced(root.right);

        if(Math.abs(left - right) > 1)
            isBalanced = false;

        return 1 + Integer.max(left,right);

    }
}
