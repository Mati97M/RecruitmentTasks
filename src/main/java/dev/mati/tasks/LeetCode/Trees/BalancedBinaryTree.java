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
    public static boolean isBalanced(TreeNode root) { //leetcode gives different result for [1]
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
    /*private static Pair<Boolean, Integer> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<Boolean, Integer>(true, 0);
        }

        var left = dfs(root.left);
        var right = dfs(root.right);

        var balanced =
                left.getKey() &&
                        right.getKey() &&
                        (Math.abs(left.getValue() - right.getValue()) <= 1);

        return new Pair<Boolean, Integer>(
                balanced,
                1 + Math.max(left.getValue(), right.getValue())
        );
    }

    public static boolean isBalanced2(TreeNode root) {
        return dfs(root).getKey();
    }*/
}
