package dev.mati.tasks.LeetCode.Trees;

import java.util.*;

public class TreeBuilder {
    public static void main(String[] args) {
        //test
        getTreeFromArr(1,2,3,4,5,6,7);
    }
    public static TreeNode getTreeFromArr(Integer... nodes) {
        if(nodes == null || nodes.length == 0)
            return null;

        List<TreeNode> nodeList = Arrays.stream(nodes)
                .map(n -> (n != null) ? new TreeNode(n) : null)
                .toList();

        Iterator<TreeNode> it = nodeList.iterator();
        TreeNode root = it.next();
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        while(it.hasNext()) {
            if(level == 0) {
                queue.offer(root);
                level++;
                continue;
            }

            int nodesPerLev = (int) Math.pow(2,level++);
            TreeNode left = null;
            TreeNode right = null;
            while(nodesPerLev > 0 && it.hasNext()) {
                if(!queue.isEmpty()) {
                    left = it.next();
                    TreeNode parent = queue.pop();
                    parent.left = left;
                    if(!it.hasNext())
                        return root;
                    right = it.next();
                    parent.right = right;
                    nodesPerLev -= 2;
                    if(left != null)
                        queue.offer(left);
                    if(right != null)
                        queue.offer(right);
                }
            }
        }
        return root;
    }
}
