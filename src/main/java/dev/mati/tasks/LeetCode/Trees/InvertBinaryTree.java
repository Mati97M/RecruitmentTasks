package dev.mati.tasks.LeetCode.Trees;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(4,2,7,1,3,6,9);
        System.out.print("Original: ");
        TreePrinter.printAsArr(root);

        System.out.print("Inverted: ");
        TreePrinter.printAsArr(invertTree(root));
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
}
