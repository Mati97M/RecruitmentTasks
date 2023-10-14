package dev.mati.tasks.LeetCode.Trees;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(3,1,4,3,null,1,5);
        System.out.println(goodNodes(root));
    }
    public static int goodNodes(TreeNode root) {
        return countGood(root, root.val);
    }
    public static int countGood(TreeNode root, int min) {
        if(root == null)
            return 0;

        if(root.val >= min) {
            return 1 + countGood(root.left, root.val) + countGood(root.right, root.val);
        } else {
            return countGood(root.left, min) + countGood(root.right, min);
        }
    }

    public static int goodNodes2(TreeNode root) {
        int[] good = {0};
        countGood2(root, good, root.val);
        return good[0];
    }
    public static void countGood2(TreeNode root, int[] good, int min) {
        if(root != null && root.val >= min) {
            good[0]++;
            min = root.val;
        }
        if(root.left != null)
            countGood2(root.left, good, min);
        if(root.right != null)
            countGood2(root.right, good, min);
    }

}
