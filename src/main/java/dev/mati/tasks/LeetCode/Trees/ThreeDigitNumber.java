package dev.mati.tasks.LeetCode.Trees;

import java.util.HashSet;

public class ThreeDigitNumber {
    public static void main(String[] args) {
        TreeNode root = TreeBuilder.getTreeFromArr(1,2,7,5,9,9,null,3);
        HashSet<String> numbers = new HashSet<>();
        countUniqNums(root,numbers);
        System.out.println(numbers.size());
        numbers.forEach(System.out::println);

        System.out.println();

        root = TreeBuilder.getTreeFromArr(1,2,3,4,5,6,null,7,null,8,9,null,9,null,null,null,null,null,null,9,9);
        numbers = new HashSet<>();
        countUniqNums(root,numbers);
        System.out.println(numbers.size());
        numbers.forEach(System.out::println);
    }
    public static void countUniqNums(TreeNode root, HashSet<String> numbers) {
        if(root == null)
            return;
        StringBuilder number = new StringBuilder();
        dfs3DigitsPreOrd(root, numbers, number);

        if(root.left != null)
            countUniqNums(root.left,numbers);
        if(root.right != null)
            countUniqNums(root.right,numbers);
    }
    public static void dfs3DigitsPreOrd(TreeNode root, HashSet<String> numbers, StringBuilder number) {
        if(root == null)
            return;
        number.append(root.getVal());
        if(number.length() == 3) {
            numbers.add(number.toString());
            number.deleteCharAt(number.length() - 1);
            return;
        }
        dfs3DigitsPreOrd(root.left,numbers,number);
        dfs3DigitsPreOrd(root.right, numbers, number);
        number.deleteCharAt(number.length() - 1);
    }
}
