package dev.mati.tasks.LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(1,2,3,null,5,null,4);
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            result.add(q.peekLast().val);
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
        }
        return result;
    }
}
