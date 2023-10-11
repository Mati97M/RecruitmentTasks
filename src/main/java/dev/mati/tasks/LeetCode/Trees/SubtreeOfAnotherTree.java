package dev.mati.tasks.LeetCode.Trees;

import java.util.LinkedList;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode t1 = TreeBuilder.getTreeFromArr(3,4,5,1,2);
        TreeNode t2 = TreeBuilder.getTreeFromArr(4,1,2);
        System.out.println(isSubtree(t1,t2));


        t1 = TreeBuilder.getTreeFromArr(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2);
        t2 = TreeBuilder.getTreeFromArr(1,null,1,null,1,null,1,null,1,null,1,2);
        System.out.println(isSubtree(t1,t2));

    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;
        if(root == null)
            return false;
        if(isTheSame(root,subRoot))
            return true;

        return (isSubtree(root.left, subRoot) ||
                isSubtree(root.right,subRoot));

    }

    public static boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        //traverse the whole tree. If the node with a target value is found, try match both trees
        LinkedList<TreeNode> nextLevel = new LinkedList<>();    //there is no null values
        nextLevel.offer(root);
        while(!nextLevel.isEmpty()) {
            TreeNode node = nextLevel.pop();
            if(node.val == subRoot.val) {
                boolean theSame = isTheSame(node,subRoot);
                if(theSame)
                    return true;
            }

            if(node.left != null)
                nextLevel.offer(node.left);
            if(node.right != null)
                nextLevel.offer(node.right);
        }
        return false;
    }
    private static boolean isTheSame(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;

        return isTheSame(root1.left,root2.left) && isTheSame(root1.right, root2.right);

    }
        /*public static boolean isSubtree3(TreeNode root, TreeNode subRoot) { //needs to be fixed
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> s = new ArrayList<>();

        dfs(root,r);
        dfs(subRoot,s);

        var rIt = r.iterator();
        var sIt = s.iterator();

        while(sIt.hasNext()) {
            if(sIt.next() != rIt.next())
                return false;
        }
        return true;
    }
    private static void dfs(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            arr.add(null);
            return;
        }
        dfs(root.left,arr);
        dfs(root.right,arr);
        arr.add(root.val);
    }*/
}
