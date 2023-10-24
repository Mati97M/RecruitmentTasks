package dev.mati.tasks.LeetCode.Trees;

public class KthSmallestElementInBST {
    private static int kthSmst = 0;
    private static int counter = 0;

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(3,1,4,null,2);
        System.out.println(kthSmallest(root,1));

        root = TreeBuilder.getTreeFromArr(5,3,6,2,4,null,null,1);
        System.out.println(kthSmallest(root,3));
    }
    public static int kthSmallest(TreeNode root, int k) {
        counter = k;
        dfsInOrder(root);
        return kthSmst;
    }
    private static void dfsInOrder(TreeNode root) {
        if(root == null)
            return;

        dfsInOrder(root.left);

        if(counter == 0)
            return;
        kthSmst = root.val;
        counter--;

        dfsInOrder(root.right);
    }

}
