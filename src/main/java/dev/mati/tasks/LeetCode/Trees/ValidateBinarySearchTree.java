package dev.mati.tasks.LeetCode.Trees;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(5,1,4,null,null,3,6);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }
    public static boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;

        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }
}
