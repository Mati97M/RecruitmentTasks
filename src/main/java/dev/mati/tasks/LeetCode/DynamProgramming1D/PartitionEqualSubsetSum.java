package dev.mati.tasks.LeetCode.DynamProgramming1D;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {//chyba jest zapetlone czy co
        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        if(nums.length == 1) return false;
        for(int n: nums) {
            sum += n;
        }
        if(sum%2 != 0) return false;
        int[][] cache = new int[nums.length][sum / 2 + 1]; //0 not visited, 1 true, -1 false
        return isTargetTill(nums.length - 1, sum / 2, nums, cache); // is target in range of 0 : n - 1
    }

    private boolean isTargetTill(int i, int target, int[] arr, int[][] cache) {
        if(cache[i][target] != 0) {
            return cache[i][target] == 1;
        }
        if(target == 0) {
            return true;
        }
        if(i == 0) return target == arr[i];
        boolean ntTake = isTargetTill(i - 1, target, arr, cache);
        boolean take = false;
        if(target >= arr[i]) {
            int rem = target - arr[i];
            take = isTargetTill(i - 1, rem, arr, cache);
        }
        boolean res = ntTake || take;
        cache[i][target] = res ? 1 : -1;
        return res;
    }

    /*public boolean canPartition(int[] nums) {
        int sum = 0;
        if(nums.length == 1) return false;
        LinkedList<Integer> q = new LinkedList<>();
        for(int n: nums) {
            sum += n;
            q.offer(n);
        }
        if(sum%2 != 0) return false;
        return dfs(q, sum / 2, 0);
    }

    private boolean dfs(LinkedList<Integer> q, int target, int total) { sth is wrong
        if(total > target)
            return false;
        if(total == target)
            return true;
        int size = q.size();
        while(size > 0) {
            int rmvd = q.poll();
            if(dfs(q, target, total + rmvd)) {
                return true;
            }
            q.offer(rmvd);
            size--;
        }
        return false;
    }*/

}
