package dev.mati.tasks.LeetCode.Greedy;

import java.util.HashMap;
import java.util.HashSet;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new JumpGame().canJumpDFS(nums));

        nums = new int[] {3,2,1,0,4};
        System.out.println(new JumpGame().canJumpDFS(nums));

        nums = new int[] {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        System.out.println(new JumpGame().canJump(nums));

    }
    public boolean canJump(int[] nums) {    //Greedy approach O(1) in space, O(n) in time
        int last = nums.length - 1;
        for(int i = nums.length - 1; i > 0; i--) {
            if(last - i <= nums[i]) {
                last = i;
            }
        }
        return last <= nums[0];
    }

    public boolean canJumpDFS(int[] nums) {
        HashMap<Integer, HashSet<Integer>> nodes = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            nodes.put(i, new HashSet<>());
            int steps = nums[i];
            while(steps > 0) {
                if(steps + i <= nums.length - 1) {
                    nodes.get(i).add(steps + i);
                }
                steps--;
            }
        }
        return dfs(nodes, nums.length - 1, 0);
    }
    private boolean dfs(HashMap<Integer, HashSet<Integer>> nodes, int lastInd, int node) {
        if(node == lastInd) {
            return true;
        }
        boolean found = false;
        for(int n: nodes.get(node)) {
            found = found || dfs(nodes, lastInd, n);
        }
        return found;
    }
}
