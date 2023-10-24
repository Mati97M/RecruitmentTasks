package dev.mati.tasks.LeetCode.Trees;

public class BinaryTreeMaxPathSum {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(-10,9,20,null,null,15,7);
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root) {
        int[] res = {root.val};
        dfsPostO(root, res);
        return res[0];
    }
    private static int dfsPostO(TreeNode root, int[] res) {
        if(root == null)
            return 0;

        int left = dfsPostO(root.left, res);
        int right = dfsPostO(root.right, res);
        left = Integer.max(left, 0);
        right = Integer.max(right, 0);

        int currPath = root.val + left + right;
        res[0] = Integer.max(currPath, res[0]);

        return root.val + Integer.max(left,right);
    }
}
