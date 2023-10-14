package dev.mati.tasks.LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(3,9,20,null,null,15,7);
        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null)
            return levels;

        LinkedList<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()) {
            var level = new ArrayList<Integer>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            levels.add(level);
        }
        return levels;
    }
    public static  List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null)
            return levels;

        LinkedList<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()) {
            var level = new ArrayList<Integer>();
            LinkedList<TreeNode> qDesc = new LinkedList<>();
            while(!q.isEmpty() ) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) {
                    qDesc.offer(node.left);
                }
                if(node.right != null) {
                    qDesc.offer(node.right);
                }
            }
            levels.add(level);
            q = qDesc;
        }
        return levels;
    }
}
