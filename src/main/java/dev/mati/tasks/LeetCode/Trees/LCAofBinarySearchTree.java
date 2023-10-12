package dev.mati.tasks.LeetCode.Trees;

import java.util.HashSet;
//lowestCommonAncestor has a connection has at least one direct connection with given nodes.
//It is the closest CommonAncestor to the given nodes
//BST ==> root.val > root.left  && root.val <= root.right
public class LCAofBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(6,2,8,0,4,7,9,null,null,3,5);
        TreeNode p = root.getNodeFromBST(2);
        TreeNode q = root.getNodeFromBST(8);
        System.out.println(lowestCommonAncestor(root,p,q).val);

        p = root.getNodeFromBST(2);
        q = root.getNodeFromBST(4);
        System.out.println(lowestCommonAncestor(root,p,q).val);

        p = root.getNodeFromBST(3);
        q = root.getNodeFromBST(5);
        System.out.println(lowestCommonAncestor(root,p,q).val);

        root = TreeBuilder.getTreeFromArr( 5,3,6,2,4,null,null,1);
        p = root.getNodeFromBST(1);
        q = root.getNodeFromBST(3);
        System.out.println(lowestCommonAncestor(root,p,q).val);

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(true) {
            if(curr.val == p.val || curr.val == q.val)
                return curr;
            if(curr.val > p.val && curr.val > q.val)
                curr = curr.left;
            else if(curr.val < p.val && curr.val < q.val)
                curr = curr.right;
            else
                return curr;
        }
    }
    public static TreeNode lowestCommonAncestorMemCostly(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        HashSet<Integer> vals = new HashSet<>();

        TreeNode curr = root;
        while(curr != p) {
            vals.add(curr.val);
            if(curr.val < p.val)
                curr = curr.right;
            else
                curr = curr.left;
        }
        vals.add(p.val);

        curr = root;
        while(curr != q) {
            if(!vals.add(curr.val)) {
                result = curr;
            }
            if(curr.val < q.val)
                curr = curr.right;
            else
                curr = curr.left;
        }
        if(!vals.add(curr.val)) {
            result = curr;
        }

        return result;
    }
}
