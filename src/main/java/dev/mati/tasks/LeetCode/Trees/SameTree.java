package dev.mati.tasks.LeetCode.Trees;

public class SameTree {
    private static boolean sameTree = true;

    public static void main(String[] args) {
        TreeNode t1 = TreeBuilder.getTreeFromArr(1,2,3);
        TreeNode t2 = TreeBuilder.getTreeFromArr(1,2,3);
        System.out.println(isSameTree(t1,t2));

        t1 = TreeBuilder.getTreeFromArr(1,2);
        t2 = TreeBuilder.getTreeFromArr(1,null,2);
        System.out.println(isSameTree(t1,t2));

        t1 = TreeBuilder.getTreeFromArr(1,2,1);
        t2 = TreeBuilder.getTreeFromArr(1,1,2);
        System.out.println(isSameTree(t1,t2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {//recursive, from bottom, checks the whole tree
        if(p == null && q == null)
            return true;
        if(p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) { //recursive, from top, till the end (if same) or finding defferent node
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
