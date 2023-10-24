package dev.mati.tasks.LeetCode.Trees;

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(5,4,8,11,null,13,4,7,2,null,null,null,1);
        int targetSum = 22;
        System.out.println(hasPathSum(root,targetSum));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        int[] curr = {0};
        return dfsPreOsearch(root, targetSum, curr);
    }
    private static boolean dfsPreOsearch(TreeNode root, int target, int[] curr) {
        if(root == null)
            return false;
        curr[0] += root.val;
        if(root.left == null && root.right == null && curr[0] == target)
            return true;

        boolean bL = false;
        if(root.left != null) {
            bL = dfsPreOsearch(root.left, target, curr);
            curr[0] -= root.left.val;
        }
        boolean bR = false;
        if(root.right != null) {
            bR = dfsPreOsearch(root.right, target, curr);
            curr[0] -= root.right.val;
        }

        return bL || bR;
    }
}
